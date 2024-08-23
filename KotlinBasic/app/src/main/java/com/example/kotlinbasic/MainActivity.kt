package com.example.kotlinbasic

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinbasic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding  // Replace with your actual binding class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            val no1 = binding.edtNo1.text.toString().toIntOrNull() ?: return@setOnClickListener
            val no2 = binding.edtNo2.text.toString().toIntOrNull() ?: return@setOnClickListener
            val sum = no1 + no2
            Toast.makeText(this@MainActivity, "Sum is $sum", Toast.LENGTH_LONG).show()
            binding.txtSum.text = "Sum is $sum"
        }
    }
}