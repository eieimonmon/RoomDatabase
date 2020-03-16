package com.example.roomwithview.repository

import androidx.lifecycle.LiveData
import com.example.roomwithview.Dao.WordDao
import com.example.roomwithview.Entity.WordEntity

class WordRepository (private val wordDao: WordDao){

    val allWords: LiveData<List<WordEntity>> = wordDao.getAlphabetizedWords()
    suspend fun insert(word: WordEntity){
        wordDao.insert(word)


    }

    suspend fun delete(){
        wordDao.delete()
    }
 }