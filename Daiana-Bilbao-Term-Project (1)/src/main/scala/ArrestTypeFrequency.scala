package main.scala
import org.apache.spark.sql.SparkSession

object ArrestTypeFrequency {

  def main(args: Array[String]): Unit = {
    val sc = SparkSession.builder().master("spark://boston:30124").getOrCreate().sparkContext

    // to run locally in IDE,
    // But comment out when creating the jar to run on cluster
    //val sc = SparkSession.builder().master("local").getOrCreate().sparkContext

    // to run with yarn, but this will be quite slow, if you like try it too
    // when running on the cluster make sure to use "--master yarn" option
    //val sc = SparkSession.builder().master("yarn").getOrCreate().sparkContext

    val text = sc.textFile(args(0))
    val header = text.first()
    val newText = text.filter(row => row != header)
    val counts = newText.map(line => line.split(",")(11)).map(k => (k,1)).reduceByKey(_+_)
    counts.saveAsTextFile(args(1))
  }
}