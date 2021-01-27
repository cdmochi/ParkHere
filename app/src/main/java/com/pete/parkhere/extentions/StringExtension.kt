package com.pete.parkhere.extentions

import android.icu.text.CaseMap.fold
import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.util.*


fun String.SHA256(): String {
    return hashString(this, "SHA-256")
}

private fun hashString(input: String, algorithm: String): String {
    return MessageDigest
        .getInstance(algorithm)
        .digest(input.toByteArray())
        .fold("", { str, it -> str + "%02x".format(it) })
}

fun formatDate(date : Date) : String {
    val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US).apply {
        timeZone = TimeZone.getTimeZone("GMT")
    }
    return simpleDateFormat.format(date)
}


