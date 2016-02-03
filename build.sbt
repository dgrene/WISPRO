    name := "WISPRO"
     
    version := "1.0"
     
    scalaVersion := "2.11.7"
     resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
    libraryDependencies ++= Seq(
    "org.apache.spark" % "spark-core_2.11" % "1.5.2",
    "org.apache.spark" % "spark-streaming-twitter_2.10" % "1.5.2",
    "com.datastax.spark" %% "spark-cassandra-connector" % "1.5.0-RC1",
    "org.apache.spark" % "spark-sql_2.11" % "1.5.2"
    )
