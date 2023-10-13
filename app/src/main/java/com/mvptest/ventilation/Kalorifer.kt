package com.mvptest.ventilation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception
import kotlin.math.roundToInt

class Kalorifer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalorifer)

        val rashod1: EditText = findViewById(R.id.rashod1)
        val tvn1: EditText = findViewById(R.id.Tvn1)
        val tnar1: EditText = findViewById(R.id.Tnar1)
        val b1: Button = findViewById(R.id.b1)
        val b2: Button = findViewById(R.id.b2)
        val result1: TextView = findViewById(R.id.result1)

        val kal_power: EditText = findViewById(R.id.kal_power)
        val tv1:EditText = findViewById(R.id.Tv1)
        val tv2: EditText = findViewById(R.id.Tv2)
        val b3: Button = findViewById(R.id.b3)
        val result2: TextView = findViewById(R.id.result2)

        val water: EditText = findViewById(R.id.water)
        val d: EditText = findViewById(R.id.d)
        val spin1: Spinner = findViewById(R.id.spin1)
        val b4: Button = findViewById(R.id.b4)
        val result3: TextView = findViewById(R.id.result3)
        val diamTrub = arrayOf("10", "15", "20", "25", "32", "40", "50", "60", "70", "80", "90", "100")

        val m1: TextView = findViewById(R.id.m1)
        val m2: TextView = findViewById(R.id.m2)
        val m3: TextView = findViewById(R.id.m3)
        val m4: TextView = findViewById(R.id.m4)
        val m5: TextView = findViewById(R.id.m5)

        b1.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.cntd.ru/document/554402860"))
            startActivity(intent)
        }

        b2.setOnClickListener {
            try {
                val a = rashod1.text.toString().toFloat()*1.23*(tvn1.text.toString().toFloat() + tnar1.text.toString().toFloat())
                result1.setText("${Math.abs((a/1000).toInt())}")
                m1.setText("кВт")
                kal_power.setText("${Math.abs((a/1000).toInt())}")
            }catch (e: Exception) {result1.setText("Некорректный ввод данных")}
        }


        b3.setOnClickListener {
            try {
                var a = ((kal_power.text.toString().toFloat()*3600) / (4.19 * (tv1.text.toString().toFloat() - tv2.text.toString().toFloat())))/1000
                a = (a * 100).roundToInt() / 100.0
                result2.setText("${a}")
                m2.setText("м3/ч")
                water.setText("${a}")
            }catch (e: Exception) {result2.setText("error")}
        }

        spin1.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, diamTrub)
        spin1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long ) {

                val selected = diamTrub[position]
                d.setText(selected)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        b4.setOnClickListener {
           try {
               val a =
                   (water.text.toString().toFloat() * 4 * 1000) / (3.6 * 3.14 * d.text.toString()
                       .toFloat() * d.text.toString().toFloat())
               result3.setText(java.lang.String.format("%.2f", a))
               m3.setText("м/с")
           }catch (e: Exception) {result3.setText("Некорректный ввод данных")}
        }

        val rashod2: EditText = findViewById(R.id.rashod2)
        val tvn2: EditText = findViewById(R.id.Tvn2)
        val tnar2: EditText = findViewById(R.id.Tnar2)
        val b5: Button = findViewById(R.id.b5)
        val b6: Button = findViewById(R.id.b6)
        val result4: TextView = findViewById(R.id.result4)

        val rashod3: EditText = findViewById(R.id.rashod3)
        val widht: EditText = findViewById(R.id.width)
        val hight: EditText = findViewById(R.id.hight)
        val b7: Button = findViewById(R.id.b7)
        val result5: TextView = findViewById(R.id.result5)


        b5.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.cntd.ru/document/554402860"))
            startActivity(intent)
        }

        b6.setOnClickListener {
            try {
                val a = rashod2.text.toString().toFloat()*1.23*(tvn2.text.toString().toFloat() + tnar2.text.toString().toFloat())
                result4.setText("${Math.abs((a/1000).toInt())}")
                m4.setText("кВт")
                kal_power.setText("${Math.abs((a/1000).toInt())}")
            }catch (e: Exception) {result4.setText("Некорректный ввод данных")}
        }

        b7.setOnClickListener {
            try {
                val a = (rashod3.text.toString().toInt() * 1000) / (3.6 * widht.text.toString()
                    .toInt() * hight.text.toString().toInt())
                result5.setText(java.lang.String.format(("%.1f"), a))
                m5.setText("м/с")
            }catch (e: Exception) {result5.setText("Некорректный ввод данных")}
        }



    }
}