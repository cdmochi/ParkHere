package com.pete.parkhere.di

import android.content.Context
import androidx.room.Room
import com.pete.parkhere.data.local.LocationDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class) //scope this object to the applicaiton
object AppModule {

    @Provides
    @Singleton
    fun provideLocalDatabaseInstance(@ApplicationContext appContext: Context) : LocationDatabase =
            Room.databaseBuilder(appContext , LocationDatabase::class.java,"locations")
                    .fallbackToDestructiveMigration()
                    .build()

}


