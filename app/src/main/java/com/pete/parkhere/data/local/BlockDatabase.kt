package com.pete.parkhere.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Block::class), version = 1)
abstract class BlockDatabase : RoomDatabase() {
    abstract fun blockDao(): BlockDao
}