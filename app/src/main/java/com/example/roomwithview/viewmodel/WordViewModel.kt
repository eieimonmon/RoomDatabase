package com.example.roomwithview.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomwithview.Entity.WordEntity
import com.example.roomwithview.database.WordDatabase
import com.example.roomwithview.repository.WordRepository
import kotlinx.coroutines.launch

class WordViewModel (application: Application): AndroidViewModel(application){
    private val repository : WordRepository
    val allWords: LiveData<List<WordEntity>>

    init {
        val wordDao = WordDatabase.getDatabase(application).wordDao()
        repository = WordRepository(wordDao)
        allWords = repository.allWords
    }

    fun insert(word: WordEntity) = viewModelScope.launch {
        repository.insert(word)
    }
}