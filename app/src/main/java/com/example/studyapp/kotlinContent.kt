package com.example.studyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

lateinit var rv_kotlin: RecyclerView

var kotlinLayoutManager: RecyclerView.LayoutManager? = null
var kotlinAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

class kotlinContent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_content)

        rv_kotlin = findViewById(R.id.rv_kotlin)

        // use a linear layout manager
        rv_kotlin.layoutManager = LinearLayoutManager(this)

        kotlinAdapter = RecyclerAdapter()

        rv_kotlin.adapter = kotlinAdapter


    }

    // menu functions
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.kotlin_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.mi_ktToMain -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.mi_ktToAndroid -> {
                val intent = Intent(this, AndroidStudioContent::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}