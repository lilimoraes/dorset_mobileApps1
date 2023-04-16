package com.example.mobileapps1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.google.android.material.snackbar.Snackbar

class MainActivity  : AppCompatActivity()

override fun onCreate(savedInstanceState: Bundle?) {
     super.onCreate(savedInstanceState)
     setContentView(R.layout.activity_main)
     
     //val rootView = window.decorView.rootView
     val rootView = findViewById<View>(R.id.root_layout)

     val helloText = findViewById<<textView>(R.id.welcomeText)
     helloText.text = getString(R.string.hello_dorset)

    val welcomeText = findViewById<TextView>(R.id.welcomeNameText)
    val saveButton = findViewById<Button>(R.id.saveButton)
    val nameEditText = findViewById<EditText>(R.id.nameEditText)
    val nameText = nameEditText.text

    saveButton.setOnClickListener {
        val welcomeTextString = "Welcome, $nameText!"
        welcomeText.text = welcomeTextString
        it.hideKeyboard()
        Toast.makeText(this, "Save Button clicked", Toast.LENGTH_LONG).show()
        val sb = Snackbar.make(rootView, "Save Button Clicked", Snackbar.LENGTH_INDEFINITE)
        sb.setActions("dimiss"){
            sb.dimiss()
            }
        sb.show()

        if(savedInstanceState == null) {
            val supportFragmentManager
            supportFragmentManager.commit {
                val bundle = bundleOf()("username" to "Inside fragment: $nameText")
                setReorderingAllowed(true)
                add<SampleFragment>(R.id.fragment_container_view, args = bundle)
            }
        }
    }

    val nextPageButton = findViewById<Button>(R.id.nextPageButton)
    nextPageButton.setOnClickListener {
        val intent = Intent(this, MainActivity2::class.java)
        starActivity(intent)
    }

 }

fun <T> findViewById(rootLayout: Int): Any {

}

fun setContentView(activityMain: Int) {

}
