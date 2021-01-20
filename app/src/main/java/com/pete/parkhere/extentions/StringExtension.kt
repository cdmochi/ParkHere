package com.pete.parkhere.extentions

import android.icu.text.CaseMap.fold
import java.security.MessageDigest


fun String.SHA256(): String {
    return hashString(this, "SHA-256")
}

private fun hashString(input: String, algorithm: String): String {
    return MessageDigest
        .getInstance(algorithm)
        .digest(input.toByteArray())
        .fold("", { str, it -> str + "%02x".format(it) })
}