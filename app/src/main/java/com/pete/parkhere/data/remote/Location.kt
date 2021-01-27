package com.pete.parkhere.data.remote


data class Location constructor(
    val name: String,
    val lat: Long,
    val lon: Long,
    val picture : String?,
    val price: Int,
    val lendDate: String,
    val lendStart: String,
    val lendEnd: String
)



