package com.example.roomwithview

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_add_word.*
import kotlinx.android.synthetic.main.item_word.*

class AddWordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_word)

        btnSave.setOnClickListener{
            val replyInt = Intent()
            if (TextUtils.isEmpty(editText.text)){
                editText.setError("Please fill the word")
                setResult(Activity.RESULT_CANCELED, replyInt)
            }
            else {
                val word: String = editText.text.toString()
                replyInt.putExtra(EXTRA_REPLY ,word)
                setResult(Activity.RESULT_OK, replyInt)
            }
            finish()

        }
    }

    companion object{
        const val EXTRA_REPLY = "REPLY_DATA"
    }
}
