package com.example.mobileapps1

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.sql.RowId


class MainActivity2 : AppCompatActivity(R.layout.activity_main2) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val listView = findViewById<ListView>(R.id.listView)
        val strArray = Array(10000) {"Something ${it * 10} "}
        listView.adapter = ArrayAdapter(this, R.layout.list_view_template, strArray)
        listView.setOnItemClickListener {parent, view, position, id ->
            val textView = view.findViewById<TextView>(R.id.text_view)
            Toast.makeText(this, "$position $id ${textView.text}", Toast.LENGTH_LONG).show()
        }

        val nextPageButton = findViewById<Button>(R.id.nextPageButton)
        nextPageButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}