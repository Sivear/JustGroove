package com.sivear.justgroove.utils
import kotlinx.datetime.*
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class TimeUtils {
    companion object {
        fun formatTimestampCompat(timestamp: Long): String {
            val instant = Instant.fromEpochMilliseconds(timestamp)
            val localDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
            return "${localDateTime.date}-${localDateTime.hour}-${localDateTime.minute}"
        }
    }

}