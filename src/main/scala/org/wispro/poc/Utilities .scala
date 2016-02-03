package org.wispro.poc
import java.text.SimpleDateFormat
import java.util.Random
import java.util.Calendar
import java.util.Date
import java.util.TimeZone
object Utilities {
  val tz = TimeZone.getTimeZone("IST");
  val SLIDE_INTERVAL = 15
  def getDateTime(): String = {
    val pattern = "dd-MM-yyyy-hh:mm:ss"
    val format = new SimpleDateFormat(pattern);
    format.setTimeZone(tz)
    return format.format(new Date())
  }
  def getTime(): String = {
    val pattern = "dd-MM-yyyy-hh-mm"
    val format = new SimpleDateFormat(pattern);
    format.setTimeZone(tz)
    return format.format(new Date())
  }
  def getDay(): String = {
    val pattern = "dd"
    val format = new SimpleDateFormat(pattern);
    format.setTimeZone(tz)
    return format.format(new Date())
  }
  def getDate(): String = {
    val pattern = "dd-MM-yyyy"
    val format = new SimpleDateFormat(pattern);
    format.setTimeZone(tz)
    return format.format(new Date())
  }
  def getHour(): String = {
    val pattern = "HH"
    val format = new SimpleDateFormat(pattern);
    format.setTimeZone(tz)
    return format.format(new Date())
  }
  def getPrevHour(): String = {
    val pattern = "HH"
    val format = new SimpleDateFormat(pattern);
    format.setTimeZone(tz)
    val date = new Date()
    date.setTime(date.getTime() - 3600 * 1000);
    return format.format(date)
  }
  def getNextHour(): String = {
    val pattern = "HH"
    val format = new SimpleDateFormat(pattern);
    format.setTimeZone(tz)
    val date = new Date()
    date.setTime(date.getTime() + 3600 * 1000);
    return format.format(date)
  }
  def getMinutes(): String = {
    val pattern = "mm"
    val format = new SimpleDateFormat(pattern);
    format.setTimeZone(tz)
    return format.format(new Date())
  }
  def getPrevMnts(): String = {
    val pattern = "mm"
    val format = new SimpleDateFormat(pattern);
    format.setTimeZone(tz)
    val date = new Date()
    date.setTime(date.getTime() - SLIDE_INTERVAL * 60000);
    return format.format(date)
  }
  def getPrev_15_Mnts(): String = {
    val pattern = "mm"
    val format = new SimpleDateFormat(pattern);
    format.setTimeZone(tz)
    val date = new Date()
    date.setTime(date.getTime() - 15 * 60000);
    return format.format(date)
  }
  def getPrev_30_Mnts(): String = {
    val pattern = "mm"
    val format = new SimpleDateFormat(pattern);
    format.setTimeZone(tz)
    val date = new Date()
    date.setTime(date.getTime() - 30 * 60000);
    return format.format(date)
  }
  def getPrev_45_Mnts(): String = {
    val pattern = "mm"
    val format = new SimpleDateFormat(pattern);
    format.setTimeZone(tz)
    val date = new Date()
    date.setTime(date.getTime() - 45 * 60000);
    return format.format(date)
  }
  def getPrevDate(): String = {
    val pattern = "dd-MM-yyyy"
    val format = new SimpleDateFormat(pattern);
    format.setTimeZone(tz)
    val date = new Date()
    date.setTime(date.getTime() - 1000 * 60 * 60 * 24);
    return format.format(date)
  }
  def getDateFolder(): String = {
    val pattern = "dd-MM-yyyy_HH_mm"
    val format = new SimpleDateFormat(pattern);
    format.setTimeZone(tz)
    return format.format(new Date())
  }
  def log(msg: String) = {
    println(msg)
  }
  def logMsgWithTime(msg: String) = {
    println("<-----------------------[" + getDateTime + "] " + msg.toUpperCase()+"------------------------->")
  }

}