package com.example.roomwithview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomwithview.Entity.WordEntity
import com.example.roomwithview.R
import kotlinx.android.synthetic.main.item_word.view.*

class WordAdapter : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    private var words = emptyList<WordEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
       val view = LayoutInflater.from(parent.context ).inflate(R.layout.item_word, parent,false)
        return WordViewHolder(view)
    }

    override fun getItemCount(): Int {
        return words.size
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(words[position])
    }

    fun setWord(words:List<WordEntity>)
    {
        this.words = words
        notifyDataSetChanged()
    }
    inner class WordViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){

        fun bind(word : WordEntity){

            itemView.txtword.text = word.word
        }
    }
}