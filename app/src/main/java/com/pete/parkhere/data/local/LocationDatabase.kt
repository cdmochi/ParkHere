package com.pete.parkhere.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Location::class), version = 2)
abstract class LocationDatabase : RoomDatabase() {
    abstract fun locationDao(): LocationDao
}