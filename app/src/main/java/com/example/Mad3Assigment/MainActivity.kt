package com.example.Mad3Assigment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sharedpref.databinding.ActivityMainBinding
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity(), ContactItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.data.adapter = MyAdapter(dataItems, WeakReference(this@MainActivity))
        binding.data.layoutManager = LinearLayoutManager(this)

    }

    override fun onItemClicked(phone: String) {
//        Toast.makeText(this, phone.toString(), Toast.LENGTH_LONG).show()
        val i = Intent(Intent.ACTION_DIAL);
        i.data = Uri.parse("tel:$phone")
        startActivity(i)
    }
}