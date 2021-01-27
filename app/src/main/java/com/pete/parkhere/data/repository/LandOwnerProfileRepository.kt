package com.pete.parkhere.data.repository

import com.pete.parkhere.data.local.Block


interface LandOwnerProfileRepository {

    suspend fun getAllBlocks(): MutableList<Block>

    suspend fun insertAll(vararg block: Block)

//    suspend fun delete(location: Block)
    
}