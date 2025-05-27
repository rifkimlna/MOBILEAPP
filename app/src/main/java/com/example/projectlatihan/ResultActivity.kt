package com.example.projectlatihan

import android.os.Bundle
import android.widget.CheckBox
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {

    private lateinit var tvHasil: TextView
    private lateinit var cbSetuju: CheckBox
    private lateinit var switchNotif: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        tvHasil = findViewById(R.id.tvHasil)
        cbSetuju = findViewById(R.id.cbSetuju)
        switchNotif = findViewById(R.id.switchNotif)

        // Terima data
        val nama = intent.getStringExtra("nama")
        val gender = intent.getStringExtra("gender")
        val kelas = intent.getStringExtra("kelas")

        tvHasil.text = "Nama: $nama\nGender: $gender\nKelas: $kelas"
    }
}