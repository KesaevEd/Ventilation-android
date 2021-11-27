package com.example.ventilation

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Sechenie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sechenie)

        val rectangle_cut: TextView = findViewById(R.id.rectangle_cut)
        val circke_cut: TextView = findViewById(R.id.circle_cut)
        val rashod: EditText = findViewById(R.id.rashod)
        val air_speed: EditText = findViewById(R.id.air_speed)
        val spin: Spinner = findViewById(R.id.spin)
        val b1: Button = findViewById(R.id.b1)

        val air_speed_list = arrayOf("Санузлы, коридоры - 9", "Конференц-залы, учебные классы, магазины - 6", "Офисы, кабинеты, номера в гостиницах, палаты в больницах - 5", "Жилые помещения - 4", "Складские помещения без рабочих мест - 18", "Складскими помещениями с рабочими местами - 12", "Производственные цеха - 19", "Технические и вспомогательные помещения - 11", " Комнаты отдыха, раздевалки - 9")

        val sizes = arrayOf("100*100", "100*200", "100*300", "100*400", "100*500", "100*600", "150*150", "300*150", "400*150", "500*150", "600*150", "700*150", "800*150", "200*200", "300*200", "400*200", "500*200", "600*200", "700*200", "800*200", "900*200", "1000*200", "300*300", "400*300", "500*300", "600*300", "700*300", "800*300", "900*300", "1000*300")

        spin.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, air_speed_list)
        spin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long ) {

                val selected = air_speed_list[position]
                val LisSelected = selected.split(" - ")
                air_speed.setText(LisSelected[1])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }

        b1.setOnClickListener {

            try {
                val a = rashod.text.toString().toFloat()/(3600*air_speed.text.toString().toFloat())
                for (i in 0 until sizes.size) {
                    val b =
                        ((sizes[i].split("*")[0].toFloat() / 1000).toFloat() * (sizes[i].split("*")[1].toFloat() / 1000))
                    if (i == 0 && a < b) {
                        rectangle_cut.setText(sizes[0])
                        circke_cut.setText("${(2 * rectangle_cut.text.split("*")[0].toInt()*rectangle_cut.text.split("*")[1].toInt())/(rectangle_cut.text.split("*")[0].toInt() + rectangle_cut.text.split("*")[1].toInt())}")
                    } else if ((i == sizes.size - 1) && (a > b)) {
                        rectangle_cut.setText(sizes[sizes.size - 1])
                        circke_cut.setText("${(2 * rectangle_cut.text.split("*")[0].toInt()*rectangle_cut.text.split("*")[1].toInt())/(rectangle_cut.text.split("*")[0].toInt() + rectangle_cut.text.split("*")[1].toInt())}")
                    } else if ((sizes[i].split("*")[0].toFloat() / 1000) * (sizes[i].split("*")[1].toFloat() / 1000) < a && a < (sizes[i + 1].split(
                            "*"
                        )[0].toFloat() / 1000) * (sizes[i + 1].split("*")[1].toFloat() / 1000)
                    ) {
                        if ((a - ((sizes[i].split("*")[0].toFloat() / 1000) * (sizes[i].split("*")[1].toFloat() / 1000))) < (((sizes[i + 1].split(
                                "*"
                            )[0].toFloat() / 1000) * (sizes[i + 1].split("*")[1].toFloat() / 1000)) - a)
                        ) {
                            rectangle_cut.setText(sizes[i])
                            circke_cut.setText("${(2 * rectangle_cut.text.split("*")[0].toInt()*rectangle_cut.text.split("*")[1].toInt())/(rectangle_cut.text.split("*")[0].toInt() + rectangle_cut.text.split("*")[1].toInt())}")
                        } else {
                            rectangle_cut.setText(sizes[i + 1])
                            circke_cut.setText("${(2 * rectangle_cut.text.split("*")[0].toInt()*rectangle_cut.text.split("*")[1].toInt())/(rectangle_cut.text.split("*")[0].toInt() + rectangle_cut.text.split("*")[1].toInt())}")

                        }
                    }
                }

            }catch (e: Exception) {rectangle_cut.setText("Некорректный ввод данных"); circke_cut.setText("Некорректный ввод данных")}
        }
    }
}