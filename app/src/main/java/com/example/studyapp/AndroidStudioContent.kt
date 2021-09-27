package com.example.studyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

lateinit var rv_android: RecyclerView

var androidLayoutManager: RecyclerView.LayoutManager? = null
var androidAdapter: RecyclerView.Adapter<android_RecyclerAdapter.ViewHolder>? = null

class AndroidStudioContent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_studio_content)

        rv_android = findViewById(R.id.rv_android)

        // use a linear layout manager
        rv_android.layoutManager = LinearLayoutManager(this)

        androidAdapter = android_RecyclerAdapter()

        rv_android.adapter = androidAdapter
    }

    // menu functions
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.android_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.mi_adToMain -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.mi_adToKotlin -> {
                val intent = Intent(this, kotlinContent::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}