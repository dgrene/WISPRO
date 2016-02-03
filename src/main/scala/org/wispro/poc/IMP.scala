package org.wispro.poc
import org.apache.spark._
import scala.util.control.Exception

object IMP {

  case class RawDataLake(
    REGID: Int,
    RECORDHEADER: String,
    AIDTYPE: String,
    NETIMESTAMP: String,
    FILLER1: String,
    NEID: String,
    FILLER2: String,
    AID: String,
    MONTYPE: String,
    MONVALUE: String,
    VALIDITY: String,
    LOCATION1: String,
    DIRECTION: String,
    FREQUENCY: String,
    FILLER3: String,
    FILLER4: String,
    PARTCNTER: Int,
    NMSTIMESTAMP: String)

  case class ProcessDataLake(
    REGID: Int,
    RECORDHEADER: String,
    AIDTYPE: String,
    NETIMESTAMP: String,
    FILLER1: String,
    NEID: String,
    FILLER2: String,
    AID: String,
    MONTYPE: String,
    MONVALUE: String,
    VALIDITY: String,
    LOCATION1: String,
    DIRECTION: String,
    FREQUENCY: String,
    FILLER3: String,
    FILLER4: String,
    PARTCNTER: Int,
    NMSTIMESTAMP: String)

  def main(args: Array[String]) {

    val conf = new SparkConf().setAppName("WISPRO-SPARKSQL").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val sqlContext = new org.apache.spark.sql.SQLContext(sc)
    import sqlContext.implicits._

    val rawDataPath = args(0)
    val queryFilePath = args(1)
    try {
      Utilities.logMsgWithTime("Programe execution started")

      val datasetRDD = sc.textFile(rawDataPath)
      val queryRDD = sc.textFile(queryFilePath)

      datasetRDD.map(_.split("\\|")).map(x => RawDataLake(x(0).toInt, x(1), x(2), x(3), x(4), x(5), x(6), x(7), x(8), x(9), x(10), x(11), x(12), x(13), x(14), x(15), x(16).toInt, x(17)))
        .toDF()
        .registerTempTable("RawDataLake")
      Utilities.logMsgWithTime("Finished Register Table")

     
      queryRDD.toArray().foreach{
        query =>
          Utilities.logMsgWithTime("Executing Query Start :: ")
          Utilities.logMsgWithTime("query :: " + query)
          sqlContext.sql(query).collect.foreach(println)
          Utilities.logMsgWithTime("Executing Query End")
      }

      Utilities.logMsgWithTime("Programe execution end")
    } catch {
      case ex: Exception => println("<<<<<<<<<<<<<<<<<<<<<<<-------- EXCEPTION ---------->>>>>>>>>>>>>>>>>>>"); println(ex.printStackTrace())
    }

    sc.stop()
  }
}