package io.marcus.restapi.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun convertDate(dateString: String): LocalDateTime {
    // Convert the String date to a LocalDateTime object.
    val localDateTime = LocalDateTime.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE_TIME)

    // Return the LocalDateTime object.
    return localDateTime
}