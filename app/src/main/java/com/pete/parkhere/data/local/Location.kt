package com.pete.parkhere.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "location")
data class Location(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    val name: String,
    val lat: Double,
    val lon: Double,
    val picture : String?,
    @ColumnInfo(name="time_from") val timeFrom: String,
    @ColumnInfo(name="time_to") val timeTo: String,
    val price: Int
)


