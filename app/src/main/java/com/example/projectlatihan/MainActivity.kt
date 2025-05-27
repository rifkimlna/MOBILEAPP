package com.example.projectlatihan

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var toLinearBtn: Button
    private lateinit var toRelativeBtn: Button
    private lateinit var toIdentityBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        toLinearBtn = findViewById(R.id.toLinearBtn)
        toLinearBtn.setOnClickListener {
            val intent = Intent(this, LinearActivity::class.java)
            startActivity(intent)
        }

        toRelativeBtn = findViewById(R.id.toRelativeBtn)
        toRelativeBtn.setOnClickListener {
            val intent = Intent(this, RelativeActivity::class.java)
            startActivity(intent)
        }

        toIdentityBtn = findViewById(R.id.toIdentityBtn)
        toIdentityBtn.setOnClickListener {
            val intent = Intent(this, IdentityActivity::class.java)
            startActivity(intent)
        }
    }
}