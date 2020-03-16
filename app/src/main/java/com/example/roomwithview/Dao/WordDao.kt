package com.example.roomwithview.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomwithview.Entity.WordEntity

@Dao
 interface WordDao {
     @Insert(onConflict = OnConflictStrategy.IGNORE)
     suspend fun insert(word: WordEntity)
    @Query (value = "Select * From word_table ORDER BY word ASC ")
    fun getAlphabetizedWords():LiveData<List<WordEntity>>



    @Query (value = "Delete From word_table")
    suspend fun delete()

 }