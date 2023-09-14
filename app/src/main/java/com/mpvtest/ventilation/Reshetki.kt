package com.mpvtest.ventilation

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.mvptest.ventilation.R

class Reshetki : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reshetki)

        val spin1: Spinner = findViewById(R.id.spin1)
        val spin2: Spinner = findViewById(R.id.spin2)
        val spin3: Spinner = findViewById(R.id.spin3)

        val diametri: EditText = findViewById(R.id.diametr)
        val rashod: EditText = findViewById(R.id.rashod)
        val air_speed: EditText = findViewById(R.id.air_speed)
        val b1: Button = findViewById(R.id.b1)
        val res1: TextView = findViewById(R.id.result1)
        val sht1: TextView = findViewById(R.id.sht1)

        val ploshad: TextView = findViewById(R.id.ploshad)
        val rashod2: EditText = findViewById(R.id.rashod2)
        val air_speed2: EditText = findViewById(R.id.air_speed2)
        val b2: Button = findViewById(R.id.b2)
        val res2: TextView = findViewById(R.id.result2)
        val sht2: TextView = findViewById(R.id.sht2)

        val air_speed_circle = arrayOf("Санузлы, коридоры - 9", "Конференц-залы, учебные классы, магазины - 6", "Офисные кабинеты, номера в гостиницах, палаты в больницах, библиотеки - 5", "Жилые помещения - 4", "Складские помещения без рабочих мест - 18", "Складскими помещениями с рабочими местами - 12", "Производственные цеха - 19", "Технические и вспомогательные помещения - 11", " Комнаты отдыха, раздевалки - 9")
        val air_speed_rectangle = arrayOf("Санузлы, коридоры - 8", "Конференц-залы, учебные классы, магазины - 7", "Кабинеты, номера в гостиницах, палаты в больницах, библиотеки - 4", "Жилые помещения - 2", "Складские помещения без рабочих мест - 18", "Складскими помещениями с рабочими местами - 12", "Производственные цеха - 19", "Технические и вспомогательные помещения - 11", " Комнаты отдыха, раздевалки - 9")
        val sizes = arrayOf("100*100", "100*200", "100*300", "100*400", "100*500", "100*600", "150*150", "300*150", "400*150", "500*150", "600*150", "700*150", "800*150", "200*200", "300*200", "400*200", "500*200", "600*200", "700*200", "800*200", "900*200", "1000*200", "300*300", "400*300", "500*300", "600*300", "700*300", "800*300", "900*300", "1000*300")

        air_speed(air_speed, spin1, air_speed_circle)
        air_speed(air_speed2, spin3, air_speed_rectangle)

        spin2.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sizes)
        spin2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long ) {

                val selected = sizes[position]
                val listSelected = selected.split("*")
                val a = ((listSelected[0].toFloat()*listSelected[1].toFloat())/1000000)
                ploshad.text = "$a"
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        b1.setOnClickListener {
            try {
                val d = diametri.text.toString().toFloat()/1000
                res1.setText("${(Math.ceil((rashod.text.toString().toFloat()/ (2820 * air_speed.text.toString().toFloat()*d*d)).toDouble())).toInt()}")
                sht1.setText("шт")
            }catch (e: Exception) {res1.setText("Некорректный ввод данных")}
        }

        b2.setOnClickListener {
            try {
                res2.setText("${(Math.ceil(rashod2.text.toString().toFloat()/ (3600 * air_speed2.text.toString().toFloat()*ploshad.text.toString().toDouble()))).toInt()}")
                sht2.setText("шт")
            }catch (e: Exception) {res2.setText("Некорректный ввод данных")}
        }


    }

    fun air_speed(editText: EditText, spinner: Spinner, list: Array<String>) {

        spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long ) {

                val selected = list[position]
                val LisSelected = selected.split(" - ")
                editText.setText(LisSelected[1])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }

    }
}