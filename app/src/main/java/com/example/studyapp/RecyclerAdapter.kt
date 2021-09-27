package com.example.studyapp

import android.app.AlertDialog
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter:RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {



    private var title = arrayOf("val name = readLine()", "String concatenation", "String Interpolation", "Try - catch", "Generate random number between 7 and 14", "Lists are immutable", "Arrays are mutable", "2D ArrayLists", "Dictionaries", "Object-oriented programming (OOP)",
        "Encapsulation","Abstraction","Inheritance","Polymorphism")
    private var body = arrayOf("create a variable that holds the input", "println(\"Hello \" + \"Sam\") ", "println(\"\$message \$name\")", "Try {\n" +
            "     } catch (e: Exception) {\n" +
            "      }", "Random.nextInt(7, 15)", "val pets = listOf(\"Fluffy\", \"Snoopy\", \"Spud\")", "val pets = arrayOf(\"Fluffy\", \"Snoopy\", \"Spud\")", "credentials = arrayListOf<ArrayList<String>>()", " in Kotlin are called Maps. \n" +
            "A Map create key value pairs.", "programming paradigm based on the concept of \"objects”.", "All important information is contained inside an object and only select information is exposed.",
        "hiding any unnecessary implementation code","Reuse code from other classes","Designing objects to share behaviours")

    var kotlinAlertTitle = ""
    var kotlinAlertMessage = ""
    var v: View? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v!!)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
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
                kotlinAlertTitle = title[adapterPosition]
                kotlinAlertMessage = body[adapterPosition]
                customAlert()
            }
        }
    }

    private fun customAlert(){
        // first we create a variable to hold an AlertDialog builder
        val dialogBuilder = AlertDialog.Builder(v!!.getRootView().getContext())

        // here we set the message of our alert dialog
        dialogBuilder.setMessage(kotlinAlertMessage)
            // positive button text and action
            .setPositiveButton("ok", DialogInterface.OnClickListener {
                    dialog, id ->
            })
        // create dialog box
        val alert = dialogBuilder.create()
        // set title for alert dialog box
        alert.setTitle("$kotlinAlertTitle")

        // show alert dialog
        alert.show()
    }
}