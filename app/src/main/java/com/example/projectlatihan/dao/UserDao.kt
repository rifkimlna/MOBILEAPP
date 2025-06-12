package com.example.projectlatihan.dao

import androidx.room.*
import com.example.projectlatihan.entity.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserEntity)

    @Query("SELECT * FROM users WHERE email = :email AND password = :password")
    fun login(email: String, password: String): UserEntity?
}