name := "intro_to_spark"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "org.apache.spark".%%("spark-core") % "1.6.2"
libraryDependencies += "com.datastax.spark".%%("spark-cassandra-connector") % "1.5.1" withSources() withJavadoc()
libraryDependencies += "org.apache.spark".%%("spark-sql") % "1.6.2"