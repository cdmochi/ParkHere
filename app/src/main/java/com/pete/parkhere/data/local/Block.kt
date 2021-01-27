package com.pete.parkhere.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pete.parkhere.extentions.SHA256

@Entity(tableName = "block")
data class Block(
                 @ColumnInfo(name = "location_json")
                 val location: String,
                 val timestamp: String,
                 val parker: String,
                 val lender: String,
                 var previous: String = ""
) {
    @PrimaryKey(autoGenerate = true)
    var index: Int = -1
    var hash: String = calculateHash()
    var timestampHash: String = timestamp.SHA256()
    var parkerHash: String = parker.SHA256()
    var lenderHash: String = lender.SHA256()

    private fun calculateHash() : String {
        return  (
                index.toString()+
                location +
                timestamp +
                lender +
                previous +
                hash ).SHA256()
    }

}

