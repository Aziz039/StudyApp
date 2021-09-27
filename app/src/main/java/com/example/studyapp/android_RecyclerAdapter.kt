package com.example.studyapp

import android.app.AlertDialog
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class android_RecyclerAdapter: RecyclerView.Adapter<android_RecyclerAdapter.ViewHolder>(){

    private var title = arrayOf("The Android Manifest allows us to request Android permissions", "Gradle files make importing dependencies possible", "Use __ mode to add some other UI Elements", "create an OnClickListener", "Recycler Views ",
    "Create a snack bar")
    private var body = arrayOf("True", "True", "Design", "myButton.setOnClickListener { myFuction() }","great way to display long lists of items to the user.", "Snackbar.make(clMain, “MSG”, Snackbar.LENGTH_LONG).show()")

    var androidAlertTitle = ""
    var androidAlertMessage = ""
    var v: View? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): android_RecyclerAdapter.ViewHolder {
        v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v!!)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cardTitle.text = title[position]
        holder.cardBody.text =  body[position]
    }

    override fun getItemCount(): Int {
        return title.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var cardTitle: TextView
        var cardBody: TextView
        init {
            cardTitle = itemView.findViewById(R.id.card_title)
            cardBody = itemView.findViewById(R.id.card_body)

            itemView.setOnClickListener {
                androidAlertTitle = title[adapterPosition]
                androidAlertMessage = body[adapterPosition]
                customAlert()
            }
        }
    }

    private fun customAlert(){
        // first we create a variable to hold an AlertDialog builder
        val dialogBuilder = AlertDialog.Builder(v!!.getRootView().getContext())

        // here we set the message of our alert dialog
        dialogBuilder.setMessage(androidAlertMessage)
            // positive button text and action
            .setPositiveButton("ok", DialogInterface.OnClickListener {
                    dialog, id ->
            })
        // create dialog box
        val alert = dialogBuilder.create()
        // set title for alert dialog box
        alert.setTitle("$androidAlertTitle")

        // show alert dialog
        alert.show()
    }



}