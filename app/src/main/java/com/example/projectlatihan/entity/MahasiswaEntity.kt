package com.example.projectlatihan.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mahasiswa")
data class MahasiswaEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nim: String,
    val namaLengkap: String,
    val umur: Int,
    val alamat: String,
    val domisili: String,
    val gambar: String
)
