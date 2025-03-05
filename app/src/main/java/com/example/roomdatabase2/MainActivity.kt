package com.example.roomdatabase2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.roomdatabase2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

  // create a room database

        val db = Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java,
            "User_Table"
        ).allowMainThreadQueries().build()

        val userDao = db.userDao()

        binding.button.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                val user = User(0, email = email, password = password)
                userDao.addUser(user)
                binding.email.text.clear()
                binding.password.text.clear()
            } else {
                Toast.makeText(this, "please enter email and password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}