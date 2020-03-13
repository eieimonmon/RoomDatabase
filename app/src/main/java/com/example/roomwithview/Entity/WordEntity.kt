package com.example.roomwithview.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
class WordEntity (

    @PrimaryKey
    @ColumnInfo(name = "word")
     val word:String = ""

)