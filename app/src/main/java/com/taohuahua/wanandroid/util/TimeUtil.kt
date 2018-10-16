package com.taohuahua.wanandroid.util

object TimeUtil {
    fun getTimeSpanFormatDate(inTime: Long): String {
        val dtMillSec = System.currentTimeMillis() - inTime

        val minuteParams = (1000 * 60).toLong()
        val hourParams = minuteParams * 60
        val dayParams = hourParams * 24
        val monthParams = dayParams * 30
        val yearParams = dayParams * 365

        val dtYear = (dtMillSec / yearParams).toInt()
        val dtMonth = (dtMillSec / monthParams).toInt()
        val dtDay = (dtMillSec / dayParams).toInt()
        val dtHour = (dtMillSec / hourParams).toInt()
        val dtMinute = (dtMillSec / minuteParams).toInt()

        return if (dtYear > 0) {
            dtYear.toString() + "年前"
        } else if (dtMonth > 0) {
            dtMonth.toString() + "个月前"
        } else if (dtDay > 0) {
            dtDay.toString() + "天前"
        } else if (dtHour > 0) {
            dtHour.toString() + "小时前"
        } else if (dtMinute > 0) {
            dtMinute.toString() + "分钟前"
        } else {
            "刚刚"
        }
    }
}