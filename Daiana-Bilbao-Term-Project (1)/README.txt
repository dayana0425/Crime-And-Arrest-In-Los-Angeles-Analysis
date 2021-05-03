Term Project: Crime And Arrest Data Analysis
Team Members: Daiana Bilbao & Xinyi Wang

This is my(Daiana) portion of the term project. With the following programs, I am answering the following questions.
(1) Crimes/Arrests that most frequently occur
(2) Safest/Unsafest times of day (using mean)

HOW TO RUN:
(1) sbt clean
(2) sbt package (Compile/Create JAR file)
(3) $SPARK_HOME/bin/spark-submit --class main.scala.<Scala Program Name> --deploy-mode client --supervise wordcountscala_2.11-0.1.jar <HDFS INPUT PATH> <HDFS OUTPUT PATH>

Examples:
$SPARK_HOME/bin/spark-submit --class main.scala.SafestestTimeOfDayBasedOnCrime --deploy-mode client --supervise wordcountscala_2.11-0.1.jar /data/crime-and-arrest-data/crime-data-from-2010-to-present.csv /SafestTimesOfDayMean

src/ folder hierarchy
CS455-Term-Project/src
└── main
    └── scala
        ├── ArrestTypeDescFrequency.scala
        ├── ArrestTypeFrequency.scala
        ├── CrimeCodeDescFrequency.scala
        ├── CrimeCodeFrequency.scala
        ├── SafestestTimeOfDayBasedOnCrime.scala
        └── UnsafestTimeOfDayBasedOnCrime.scala

Here I have copied over the outputs of each job. There are 6 output files in total for 6 jobs.
CS455-Term-Project/outputs
├── Arrest-Type-Freq.txt <= ArrestTypeFrequency.scala
├── Crime-Code-Desc-Freq.txt <= CrimeCodeDescFrequency.scala
├── CrimeCodeFreq.txt <= CrimeCodeFrequency.scala
├── SafestTimesOfDayMean.txt <= SafestestTimeOfDayBasedOnCrime.scala
├── Top-Ten-Arrest-Type-Desc.txt <= ArrestTypeDescFrequency.scala
└── UnsafestTimesOfDayMean.txt <= UnsafestTimeOfDayBasedOnCrime.scala

