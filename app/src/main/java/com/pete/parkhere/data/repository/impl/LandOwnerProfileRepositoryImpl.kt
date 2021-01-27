package com.pete.parkhere.data.repository.impl

import com.pete.parkhere.data.local.Block
import com.pete.parkhere.data.local.BlockDatabase
import com.pete.parkhere.data.repository.LandOwnerProfileRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LandOwnerProfileRepositoryImpl @Inject constructor(private val blockLocalDB: BlockDatabase)
    : LandOwnerProfileRepository {

    override suspend fun getAllBlocks(): MutableList<Block> {

        return blockLocalDB
                .blockDao()
                .getAllBlocks()
    }

    override suspend fun insertAll(vararg block: Block) {
        blockLocalDB
                .blockDao()
                .insertAll(*block)
    }


//    override suspend fun delete(block: Block) {
//        blockLocalDB
//                .blockDao()
//                .delete(block)
//    }
}