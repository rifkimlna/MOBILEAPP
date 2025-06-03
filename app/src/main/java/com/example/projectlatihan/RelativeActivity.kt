package com.example.projectlatihan

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class RelativeActivity : AppCompatActivity() {

    private lateinit var loginBtn: Button
    private lateinit var googleBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_relative)

        loginBtn = findViewById(R.id.loginBtn)
        loginBtn.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("User Login Confirmation")
            builder.setMessage("Are you sure want to login?")

            builder.setPositiveButton("Yes") { dialog, _ ->
                val intent = Intent(this, LinearActivity::class.java)
                startActivity(intent)
                dialog.dismiss()
            }

            builder.setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }

            val dialog = builder.create()
            dialog.show()
        }

        googleBtn = findViewById(R.id.googleLoginBtn)
        googleBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(intent)
        }
    }
}