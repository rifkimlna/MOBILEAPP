package com.example.projectlatihan


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.projectlatihan.database.AppDatabase
import com.example.projectlatihan.entity.UserEntity


class RelativeActivity : AppCompatActivity() {


    private lateinit var loginBtn: Button
    private lateinit var googleBtn: Button
    private lateinit var etMail: EditText
    private lateinit var etPassword: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_relative)


        val db = AppDatabase.getDatabase(this)


        val existingUser = db.userDao().login("rifkimaulana@example.com", "12345678")
        if (existingUser == null) {
            db.userDao().insertUser(
                UserEntity(name = "Rifki Maulana", email = "rifkimaulana@example.com", password = "12345678")
            )
        }


        etMail = findViewById(R.id.etMail)
        etPassword = findViewById(R.id.etPassword)
        loginBtn = findViewById(R.id.loginBtn)


        loginBtn.setOnClickListener {
            val email = etMail.text.toString()
            val password = etPassword.text.toString()


            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Email atau password tidak boleh kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val user = db.userDao().login(email, password)
            if (user != null) {
                val intent = Intent(this, ProfileActivity::class.java).apply {
                    putExtra("name", user.name)
                }
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Email atau password salah", Toast.LENGTH_SHORT).show()
            }
        }


        googleBtn = findViewById(R.id.googleLoginBtn)
        googleBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(intent)
        }
    }
}
