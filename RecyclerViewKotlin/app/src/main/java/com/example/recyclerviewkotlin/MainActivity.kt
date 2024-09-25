package com.example.recyclerviewkotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val arrContact = ArrayList<ContactModel>()
        arrContact.add(ContactModel(R.drawable.baseline_person_24,"A","9876543210"))
        arrContact.add(ContactModel(R.drawable.baseline_person_24,"B","9876543210"))
        arrContact.add(ContactModel(R.drawable.baseline_person_24,"C","9876543210"))
        arrContact.add(ContactModel(R.drawable.baseline_person_24,"D","9876543210"))
        arrContact.add(ContactModel(R.drawable.baseline_person_24,"E","9876543210"))
        arrContact.add(ContactModel(R.drawable.baseline_person_24,"F","9876543210"))
        arrContact.add(ContactModel(R.drawable.baseline_person_24,"G","9876543210"))
        arrContact.add(ContactModel(R.drawable.baseline_person_24,"H","9876543210"))

        binding.recyclerView.layoutManager = GridLayoutManager(this,4)
        binding.recyclerView.adapter = RecyclerContactAdapter(this,arrContact)
    }
}