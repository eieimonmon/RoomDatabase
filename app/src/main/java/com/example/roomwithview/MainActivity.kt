package com.example.roomwithview

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomwithview.Entity.WordEntity
import com.example.roomwithview.adapter.WordAdapter
import com.example.roomwithview.viewmodel.WordViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val AddWordActivityCode = 1

    private lateinit var wordViewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd.setOnClickListener{
            val intent = Intent(
                this@MainActivity,
                AddWordActivity::class.java
            )
            //startActivity(intent)
            startActivityForResult(intent,AddWordActivityCode )
        }

        btnDelete.setOnClickListener{
            wordViewModel.delete()
        }



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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){

        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == AddWordActivityCode && resultCode == Activity.RESULT_OK){
            data?.getStringExtra(AddWordActivity.EXTRA_REPLY)?.let {
                val word = WordEntity(it)
                wordViewModel.insert(word)
            }
            val w: String? = data?.getStringExtra(AddWordActivity.EXTRA_REPLY)
            Log.d("word main>>>>>", "$w")        }
    }

}
