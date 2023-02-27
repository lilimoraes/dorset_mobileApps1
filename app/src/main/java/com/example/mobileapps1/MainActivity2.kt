package com.example.mobileapps1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity(R.layout.activity_main2) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val textViewContainer = findViewById<LinearLayout>(R.id.textViewsContainer)
        for (i in 0..10000) {
            val textView = TextView(this).apply {
                val t = "Something $i"
                text = t
            }
            textViewContainer.addView(textView)
        }

        val nextPageButton = findViewById<Button>(R.id.nextPageButton)
        nextPageButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}