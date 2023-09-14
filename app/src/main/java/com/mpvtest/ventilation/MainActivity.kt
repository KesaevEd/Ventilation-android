package com.mpvtest.ventilation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.mvptest.ventilation.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ib1: ImageButton = findViewById(R.id.b1)
        val b1: Button = findViewById(R.id.rashod)

        ib1.setOnClickListener {
            val intent = Intent(this, Vozduhoobmen::class.java)
            startActivity(intent)
        }
        b1.setOnClickListener {
            val intent = Intent(this, Vozduhoobmen::class.java)
            startActivity(intent)
        }

        val ib7: ImageButton = findViewById(R.id.b7)
        val b7: Button = findViewById(R.id.kondicioneri)

        ib7.setOnClickListener {
            val intent = Intent(this, Conditional::class.java)
            startActivity(intent)
        }
        b7.setOnClickListener {
            val intent = Intent(this, Conditional::class.java)
            startActivity(intent)
        }

        val ib5: ImageButton = findViewById(R.id.b5)
        val b5: Button = findViewById(R.id.reshetki)

        ib5.setOnClickListener {
            val intent = Intent(this, Reshetki::class.java)
            startActivity(intent)
        }
        b5.setOnClickListener {
            val intent = Intent(this, Reshetki::class.java)
            startActivity(intent)
        }

        val ib4: ImageButton = findViewById(R.id.b4)
        val b4: Button = findViewById(R.id.sechenie)

        ib4.setOnClickListener {
            val intent = Intent(this, Sechenie::class.java)
            startActivity(intent)
        }
        b4.setOnClickListener {
            val intent = Intent(this, Sechenie::class.java)
            startActivity(intent)
        }

        val ib6: ImageButton = findViewById(R.id.b6)
        val b6: Button = findViewById(R.id.kaloriferi)

        ib6.setOnClickListener {
            val intent = Intent(this, Kalorifer::class.java)
            startActivity(intent)
        }
        b6.setOnClickListener {
            val intent = Intent(this, Kalorifer::class.java)
            startActivity(intent)
        }

        val ib2: ImageButton = findViewById(R.id.b2)
        val b2: Button = findViewById(R.id.aerodinamica)

        ib2.setOnClickListener {
            val intent = Intent(this, Aerodinamica::class.java)
            startActivity(intent)
        }
        b2.setOnClickListener {
            val intent = Intent(this, Aerodinamica::class.java)
            startActivity(intent)
        }
    }
}