package com.example.roomwithview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomwithview.adapter.WordAdapter
import com.example.roomwithview.viewmodel.WordViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var wordViewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wordAdapter = WordAdapter()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = wordAdapter
        }

        wordViewModel = ViewModelProvider(this)
            .get(WordViewModel::class.java)

        wordViewModel.allWords.observe(this,
            Observer {words ->
                words?.let{
                    wordAdapter.setWord(it)}
            })

    }

}
