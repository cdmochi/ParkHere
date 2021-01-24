package com.pete.parkhere.data.local

import androidx.room.*

@Dao
interface LocationDao {

    @Query("SELECT * FROM location")
    suspend fun getAllLocations(): MutableList<Location>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg locations: Location)

    @Delete
    suspend fun delete(location: Location)
}