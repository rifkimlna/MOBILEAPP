package com.example.projectlatihan.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update
import androidx.room.Delete
import androidx.room.Query
import com.example.projectlatihan.entity.MahasiswaEntity

@Dao
interface MahasiswaDao {

    @Insert
    fun insert(mahasiswa: MahasiswaEntity)

    @Update
    fun update(mahasiswa: MahasiswaEntity)

    @Delete
    fun delete(mahasiswa: MahasiswaEntity)

    @Query("SELECT * FROM mahasiswa ORDER BY id DESC")
    fun getAll(): List<MahasiswaEntity>
}
