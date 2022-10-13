package com.alireza.firstkmmapp.domain.time

import kotlinx.datetime.*

object DateTimeUtil {

    fun now(): LocalDateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())

    fun toEpochMillis(dataTime: LocalDateTime): Long =
        dataTime.toInstant(TimeZone.currentSystemDefault()).toEpochMilliseconds()


    fun formantNoteDate(dataTime: LocalDateTime): String {
        val month = dataTime.month.name.lowercase().take(3).replaceFirstChar { it.uppercase() }
        val day = if (dataTime.dayOfMonth < 10) "0${dataTime.dayOfMonth}" else dataTime.dayOfMonth
        val year = dataTime.year
        val hour = if (dataTime.hour < 10) "0${dataTime.hour}" else dataTime.hour
        val minute = if (dataTime.minute < 10) "0${dataTime.minute}" else dataTime.minute

        return buildString {
            append(month)
            append(" ")
            append(day)
            append(" ")
            append(year)
            append(", ")
            append(hour)
            append(":")
            append(minute)
        }
    }
}