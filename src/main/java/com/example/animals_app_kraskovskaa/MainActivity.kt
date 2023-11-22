package com.example.animals_app_kraskovskaa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.animals_app_kraskovskaa.Animal


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animalList = listOf(
            Animal("Banny", "rabbit1 ", R.drawable.rabbit1),
            Animal("Renny", "rabbit2", R.drawable.rabbit2),
            Animal("Tony", "rabbit3",  R.drawable.rabbit3)
        )

        val button1 = findViewById<Button>(R.id.button2)
        val button2 = findViewById<Button>(R.id.button3)
        val button3 = findViewById<Button>(R.id.button4)

        findViewById<TextView>(R.id.textView3).text = animalList[0].name
        findViewById<TextView>(R.id.textView4).text = animalList[1].name
        findViewById<TextView>(R.id.textView5).text = animalList[2].name

        button1.setOnClickListener {
            navigateToDetail(animalList[0])
        }

        button2.setOnClickListener {
            navigateToDetail(animalList[1])
        }

        button3.setOnClickListener {
            navigateToDetail(animalList[2])
        }
    }

    private fun navigateToDetail(animal: Animal) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("name", animal.name)
        intent.putExtra("description", animal.description)
        intent.putExtra("imageResource", animal.image)
        startActivity(intent)
    }
}

