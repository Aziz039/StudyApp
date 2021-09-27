package com.example.studyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button

lateinit var bt_kotlinMain: Button
lateinit var bt_androidMain: Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set Buttons
        bt_kotlinMain = findViewById(R.id.bt_kotlinMain)
        bt_androidMain = findViewById(R.id.bt_androidMain)

        // onClickListeners
        bt_kotlinMain.setOnClickListener { kotlinContentsButton() }
        bt_androidMain.setOnClickListener { androidContentsButton() }

    }

    // menu functions
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.mi_toKotlin -> {
                kotlinActivity()
                return true
            }
            R.id.mi_toAndroid -> {
                androidActivity()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


    // Buttons functions
    fun kotlinContentsButton() {
        kotlinActivity()
    }
    fun androidContentsButton() {
        androidActivity()
    }

    // activity functions
    fun kotlinActivity() {
        val intent = Intent(this, kotlinContent::class.java)
        startActivity(intent)
    }
    fun androidActivity() {
        val intent = Intent(this, AndroidStudioContent::class.java)
        startActivity(intent)
    }

}