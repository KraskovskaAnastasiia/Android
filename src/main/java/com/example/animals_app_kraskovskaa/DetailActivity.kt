package com.example.animals_app_kraskovskaa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("description")
        val imageResource = intent.getIntExtra("imageResource", 0)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val nameTextView = findViewById<TextView>(R.id.name)
        val descriptionTextView = findViewById<TextView>(R.id.description)

        imageView.setImageResource(imageResource)
        nameTextView.text = name
        descriptionTextView.text = description

        val backButton = findViewById<Button>(R.id.backButton)

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}