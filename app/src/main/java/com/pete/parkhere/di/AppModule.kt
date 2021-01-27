package com.pete.parkhere.di

import android.content.Context
import androidx.room.Room
import com.pete.parkhere.data.local.BlockDatabase
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
    fun provideLocalDatabaseInstance(@ApplicationContext appContext: Context) : BlockDatabase =
            Room.databaseBuilder(appContext , BlockDatabase::class.java,"blocks_database")
                    .fallbackToDestructiveMigration()
                    .build()

}


