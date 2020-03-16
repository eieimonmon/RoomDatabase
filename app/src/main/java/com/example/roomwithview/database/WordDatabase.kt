package com.example.roomwithview.database

import android.content.Context
import androidx.room.Database

import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomwithview.Dao.WordDao
import com.example.roomwithview.Entity.WordEntity


@Database(entities = arrayOf(WordEntity::class), version = 1)
abstract class WordDatabase : RoomDatabase(){
    abstract fun wordDao() : WordDao

    companion object{

        //singleton prevents multiple instance of database
        //opening at hte same time

        private var INSTANCE : WordDatabase? = null

        fun getDatabase(
            context: Context
        ): WordDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    WordDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}