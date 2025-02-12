package com.example.roomdatabase2

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface UserDao {
    @Insert
    fun addUser(user: User)
}