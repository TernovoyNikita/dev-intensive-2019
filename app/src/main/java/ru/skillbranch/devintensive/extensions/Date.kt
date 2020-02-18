package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern:String="HH:mm:ss dd.MM.yy"):String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value:Int, utils: TimeUtits = TimeUtits.SECOND):Date {
    var time = this.time

    time += when(utils){
        TimeUtits.SECOND -> value * SECOND
        TimeUtits.MINUTE -> value * MINUTE
        TimeUtits.HOUR -> value * HOUR
        TimeUtits.DAY -> value * DAY
    }

    this.time = time
    return this
}

fun Date.humanizeDiff(date:Date = Date()): String {
    //TODO FIX ME!!!
    return ""
}

enum class TimeUtits{
    SECOND,
    MINUTE,
    HOUR,
    DAY
}