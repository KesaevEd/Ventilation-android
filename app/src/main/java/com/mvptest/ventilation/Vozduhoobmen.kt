package com.mvptest.ventilation

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Vozduhoobmen : AppCompatActivity() {

    private val USERID = 6000
    private var countID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vozduhoobmen)

        val air_supply: TextView = findViewById(R.id.air_supply)
        val range_hood: TextView = findViewById(R.id.range_hood)
        val m1:TextView = findViewById(R.id.m1)
        val m2:TextView = findViewById(R.id.m2)

        var count: Int = 0
        val obiem: EditText = findViewById(R.id.obiem)
        val kratnost1: TextView = findViewById(R.id.kratnost1)
        val spin: Spinner = findViewById(R.id.spin)

        gadgets(spin, kratnost1)

        val add: Button = findViewById(R.id.add)

        val container: LinearLayout = findViewById(R.id.containers)

        var total: Float = 0F

        val AllEditText = ArrayList<View>()

        val tv1: TextView = findViewById(R.id.tv1)
        val tv2: TextView = findViewById(R.id.tv2)


// Обработка кнопки добавления помещения

        add.setOnClickListener {
            val layout = getLayoutInflater().inflate(R.layout.fragment1, null)
            val layout1: LinearLayout = layout.findViewById(R.id.linearLayout4)
            val et1: EditText = layout1.findViewById(R.id.obiem)
            val remove: Button = layout1.findViewById(R.id.remove)
            val layout2: LinearLayout = layout.findViewById(R.id.linearLayout5)
            val et2: TextView = layout2.findViewById(R.id.kratnost)
            val spin1: Spinner = layout2.findViewById(R.id.spin)
            val res1: TextView = findViewById(R.id.result1)

            gadgets(spin1, et2)

            layout.id = USERID + countID

            //ОБРАБОТКА КНОПКИ УДАЛЕНИЯ ПОМЕЩЕНИЯ

            remove.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    count--
                    try {
                        res1.setText(
                            "${
                                (res1.text.toString().toFloat() - et1.text.toString()
                                    .toInt() * et2.text.toString().toInt()).toInt()
                            }"
                        )
                        total -= et1.text.toString().toInt() * et2.text.toString().toInt()
                    } catch (e: Exception) {
                    }
                    AllEditText.remove(layout)
                    container.removeView(layout)
                }
            })

            AllEditText.add(layout)
            container.addView(layout)
            count++
        }

        //Нахождение Объема по кратности

        val b1: Button = findViewById(R.id.b1)
        val result1: TextView = findViewById(R.id.result1)
        val result2: TextView = findViewById(R.id.result2)

        b1.setOnClickListener {

            try {
                for (i in 0 until count) {
                    total += AllEditText.get(i).findViewById<TextView>(R.id.obiem).text.toString()
                        .toFloat() * AllEditText.get(i)
                        .findViewById<TextView>(R.id.kratnost).text.toString().toFloat()
                }
            }catch (e: Exception) {result1.setText("Некорректный ввод данных")}

            try {
                val a = obiem.text.toString().toFloat()
                val b = kratnost1.text.toString().toFloat()

                result1.setText("${((a * b) + total).toInt()}")

            } catch (e: Exception) {
                result1.setText("Некорректный ввод данных")
            }
            total = 0F

            try {
                air_supply.setText(
                    "${
                        maxOf(
                            result1.text.toString().toInt(),
                            result2.text.toString().toInt()
                        )
                    }"
                )
                range_hood.setText("${(air_supply.text.toString().toInt() * 0.9).toInt()}")
                tv1.setText("м3/ч")
                m1.setText("м3/ч")
                m2.setText("м3/ч")
            }catch (e: Exception) {
                result1.setText("Некорректный ввод данных")
            }

        }


        //САНИТАРНЫЕ НОРМЫ


        val kol_vo: EditText = findViewById(R.id.kol_vo_chelov)
        val naznach: TextView = findViewById(R.id.naznachenie_pom)
        val spin2: Spinner = findViewById(R.id.spin2)

        SanNormi(spin2, naznach)

        val b2: Button = findViewById(R.id.b2)
        val add2: Button = findViewById(R.id.add2)

        val container2: LinearLayout = findViewById(R.id.containers2)

        val AllEditText2 = ArrayList<View>()

        var total2: Float = 0F

        // Обработка кнопки добавления помещения

        add2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                val layout = getLayoutInflater().inflate(R.layout.fragment2, null)
                val layout1: LinearLayout = layout.findViewById(R.id.linearLayout8)
                val et1: EditText = layout1.findViewById(R.id.kol_vo_chelov)
                val remove: Button = layout1.findViewById(R.id.remove2)
                val layout2: LinearLayout = layout.findViewById(R.id.linearLayout9)
                val et2: TextView = layout2.findViewById(R.id.naznachenie_pom)
                val spin2: Spinner = layout2.findViewById(R.id.spin2)
                val res1: TextView = findViewById(R.id.result2)

                SanNormi(spin2, et2)

                layout.id = USERID + countID

                //ОБРАБОТКА КНОПКИ УДАЛЕНИЯ ПОМЕЩЕНИЯ

                remove.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        count--
                        try {
                            res1.setText("${(res1.text.toString().toFloat() -  et1.text.toString().toInt() * et2.text.toString().toInt()).toInt()}")
                            total2 -= et1.text.toString().toInt() * et2.text.toString().toInt()
                        }catch (e: Exception) {}
                        AllEditText2.remove(layout)
                        container2.removeView(layout)
                    }
                })

                AllEditText2.add(layout)
                container2.addView(layout)
                count ++
            }
        })

        b2.setOnClickListener {
            val AllET2 = AllEditText2.joinToString()

            try {
                for (i in 0 until count) {
                    total += AllEditText2.get(i).findViewById<EditText>(R.id.kol_vo_chelov).text.toString().toFloat() * AllEditText2.get(i).findViewById<EditText>(
                        R.id.naznachenie_pom
                    ).text.toString().toFloat()
                }
            }catch (e: Exception) {result2.setText("Некорректный ввод данных")}

            try {
                val a = kol_vo.text.toString().toFloat()
                val b = naznach.text.toString().toFloat()

                result2.setText("${((a * b) + total).toInt()}")

            } catch (e: Exception) {
                result2.setText("Некорректный ввод данных")
            }
            total = 0F

            try {
                air_supply.setText(
                    "${
                        maxOf(
                            result1.text.toString().toInt(),
                            result2.text.toString().toInt()
                        )
                    }"
                )
                range_hood.setText("${(air_supply.text.toString().toInt() * 0.9).toInt()}")
                tv2.setText("м3/ч")
                m1.setText("м3/ч")
                m2.setText("м3/ч")
            }catch (e: Exception) {result2.setText("Некорректный ввод данных")}
        }
    }

    fun gadgets(spinner: Spinner, kratnost: TextView) {

        val kratnosti = arrayOf(
            "Кухня квартиры или общежития",
            "Ванная комната, душевая",
            "Туалет",
            "Гараж",
            "Погреб",
            "Офисное помещение",
            "Банк",
            "Ресторан",
            "Бар, кафе",
            "Кухонное помещение в кафе",
            "Магазин, аптека",
            "Гараж и авторемонтная мастерская",
            "Общественный туалет",
            "Комната для курения",
            "Серверная",
            "Парикмахерская",
            "Склад",
            "Прачечная",
            "Бассейн",
            "Промышленный красильный цех",
            "Механическая мастерская",
            "Школьный класс"
        )

        spinner.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, kratnosti)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (kratnosti[position] == "Кухня квартиры или общежития" || kratnosti[position] == "Ванная комната, душевая" || kratnosti[position] == "Туалет" || kratnosti[position] == "Гараж" || kratnosti[position] == "Гараж и авторемонтная мастерская") {
                    kratnost.setText("8")
                } else if (kratnosti[position] == "Прачечная" || kratnosti[position] == "Погреб" || kratnosti[position] == "Офисное помещение" || kratnosti[position] == "Серверная" || kratnosti[position] == "Школьный класс") {
                    kratnost.setText("7")
                } else if (kratnosti[position] == "Бар, кафе" || kratnosti[position] == "Комната для курения" || kratnosti[position] == "Ресторан" || kratnosti[position] == "Общественный туалет") {
                    kratnost.setText("10")
                } else if (kratnosti[position] == "Гардеробная комната" || kratnosti[position] == "Склад") {
                    kratnost.setText("2")
                } else if (kratnosti[position] == "Магазин, аптека" || kratnosti[position] == "Парикмахерская" || kratnosti[position] == "Банк") {
                    kratnost.setText("3")
                } else if (kratnosti[position] == "Кухонное помещение в кафе" || kratnosti[position] == "Бассейн") {
                    kratnost.setText("15")
                } else if (kratnosti[position] == "Промышленный красильный цех") {
                    kratnost.setText("35")
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                kratnost.setText("0")
            }
        }
    }

    fun SanNormi(spinner: Spinner, result: TextView){

        val naznachenie = arrayOf(
            "Временное пребывание человека",
            "Длительное пребывание человека",
            "Спортивный зал"
        )

        spinner.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, naznachenie)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (naznachenie[position] == "Временное пребывание человека") {
                    result.setText("20")
                } else if (naznachenie[position] == "Длительное пребывание человека") {
                    result.setText("40")
                } else if (naznachenie[position] == "Спортивный зал") {
                    result.setText("80")
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                result.setText("0")
            }
        }

    }

}