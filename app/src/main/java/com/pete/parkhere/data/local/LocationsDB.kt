package com.pete.parkhere.data.local

import android.content.Context
import androidx.room.Room
import com.pete.parkhere.Utility.SingletonHolder

object LocationsDB: SingletonHolder<LocationDatabase, Context>({ context: Context->
    Room.databaseBuilder(context.applicationContext, LocationDatabase::class.java,"locations")
        .fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .build()
})