package com.example.projectlatihan

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class IdentityActivity : AppCompatActivity() {

    private lateinit var etNama: EditText
    private lateinit var rgGender: RadioGroup
    private lateinit var spinnerKelas: Spinner
    private lateinit var btnKirim: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_identity)

        etNama = findViewById(R.id.etNama)
        rgGender = findViewById(R.id.rgGender)
        spinnerKelas = findViewById(R.id.spinnerKelas)
        btnKirim = findViewById(R.id.btnKirim)

        // Data Spinner
//        val kelasList = arrayOf("10", "11", "12")
//        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, kelasList)
//        spinnerKelas.adapter = adapter

        btnKirim.setOnClickListener {
            val nama = etNama.text.toString()
            val selectedGenderId = rgGender.checkedRadioButtonId
            val gender = findViewById<RadioButton>(selectedGenderId)?.text.toString()
            val kelas = spinnerKelas.selectedItem.toString()

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("nama", nama)
            intent.putExtra("gender", gender)
            intent.putExtra("kelas", kelas)
            startActivity(intent)
        }
    }
}