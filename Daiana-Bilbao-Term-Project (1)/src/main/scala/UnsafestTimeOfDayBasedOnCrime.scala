package main.scala
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.expressions.Window


object UnsafestTimeOfDayBasedOnCrime {

  def main(args: Array[String]): Unit = {

    //val sc = SparkSession.builder().master("spark://boston:30124").getOrCreate().sparkContext
    val spark = SparkSession.builder().master("spark://boston:30124").getOrCreate()
    spark.conf.set("spark.sql.debug.maxToStringFields", 100)
    // to run locally in IDE
    //val sc = SparkSession.builder().master("local").getOrCreate().sparkContext

    // to run with yarn
    //val sc = SparkSession.builder().master("yarn").getOrCreate().sparkContext

    val crimeDataFrame = spark.read
      .format("csv")
      .option("header", "true")
      .option("charset", "UTF8")
      .load(args(0))

    val totalNumberOfCrimes = crimeDataFrame.count()
    val df = crimeDataFrame.groupBy("Time Occurred").count().toDF()
    val group = df.withColumn("Mean", (col("count") / totalNumberOfCrimes)).orderBy(desc("Mean")).limit(5)
    group.printSchema()
    group.select("Time Occurred", "Mean").write.format("csv").save(args(1))
  }
}