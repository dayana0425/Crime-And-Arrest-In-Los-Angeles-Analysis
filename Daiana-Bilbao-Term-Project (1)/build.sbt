name := "WordCountScala"
version := "0.1"
scalaVersion := "2.11.8"
//https://mvnrepository.com/artifact/org.apache.spark/spark-core
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.7"
//https://mvnrepository.com/artifact/org.apache.spark/spark-sql
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.7"
//https://mvnrepository.com/artifact/org.apache.spark/spark-graphx
libraryDependencies += "org.apache.spark" %% "spark-graphx" % "2.4.7"
artifactName := { (sv: ScalaVersion, module: ModuleID, artifact: Artifact) => artifact.name + "_" + sv.binary + "-" + module.revision + "." + artifact.extension }
