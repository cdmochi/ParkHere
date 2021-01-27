package com.pete.parkhere.data.local

import androidx.room.*

@Dao
interface BlockDao {

    @Query("SELECT * FROM block")
    suspend fun getAllBlocks(): MutableList<Block>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg block: Block)

    @Query("SELECT * FROM block WHERE `index` = (SELECT MAX(`index`) FROM block ) ")
    suspend fun getLatestBlock(): Block


//    @Delete
//    suspend fun delete(block: Block)
}