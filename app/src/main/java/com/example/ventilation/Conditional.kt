package com.example.ventilation

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Conditional : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conditional)

        val result3: TextView = findViewById(R.id.result3)
        val kvt: TextView = findViewById(R.id.kvt)

        val spin3: Spinner = findViewById(R.id.spin3)

        val temp = arrayOf("В состоянии покоя при t 10-20 С", "В состоянии покоя при t 25-35 С", "При легкой работе при t окр. среды 10-20 С", "При легкой работе при t окр. среды 25-35 С", "При работе средней тяжести", "При тяжелой работе")

        spin3.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, temp)
        spin3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long ) {
                if (temp[position] == "В состоянии покоя при t 10-20 С"){
                    result3.setText("145")
                }
                else if(temp[position] == "В состоянии покоя при t 25-35 С"){
                    result3.setText("93")
                }
                else if(temp[position] == "При легкой работе при t окр. среды 10-20 С"){
                    result3.setText("165")
                }
                else if(temp[position] == "При легкой работе при t окр. среды 25-35 С"){
                    result3.setText("146")
                }
                else if(temp[position] == "При работе средней тяжести"){
                    result3.setText("225")
                }
                else if(temp[position] == "При тяжелой работе"){
                    result3.setText("291")
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }

        val kol_vo_chelov2: EditText = findViewById(R.id.kol_vo_chelov2)
        val osveshenie: EditText = findViewById(R.id.osvechenie)
        val spin4: Spinner = findViewById(R.id.spin4)
        val ploshad: EditText = findViewById(R.id.ploshad)

        val intens = arrayOf("Тусклое 25 Вт/м2", "Среднее 50 Вт/м2", "Яркое 75 Вт/м2", "Очень яркое 100 Вт/м2")

        spin4.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, intens)
        spin4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long ) {
                if (intens[position] == "Тусклое 25 Вт/м2"){
                    osveshenie.setText("25")
                }
                else if(intens[position] == "Среднее 50 Вт/м2"){
                    osveshenie.setText("50")
                }
                else if(intens[position] == "Яркое 75 Вт/м2"){
                    osveshenie.setText("75")
                }
                else if(intens[position] == "Очень яркое 100 Вт/м2"){
                    osveshenie.setText("100")
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }

        val result4: TextView = findViewById(R.id.result4)
        val spin5: Spinner = findViewById(R.id.spin5)
        val gadget1: EditText = findViewById(R.id.count_gadget1)
        val wt: TextView = findViewById(R.id.wt1)
        val add: Button = findViewById(R.id.add)

        gadgets(spin5, wt)

        val container: LinearLayout = findViewById(R.id.container)

        val AllEditText = ArrayList<View>()

        var total: Float = 0F

        var count = 0

        // Обработка кнопки добавления помещения

        add.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                val layout = getLayoutInflater().inflate(R.layout.fragment_conditional, null)
                val layout1: LinearLayout = layout.findViewById(R.id.linearLayout17)
                val wt: TextView = layout1.findViewById(R.id.wt1)
                val remove: Button = layout1.findViewById(R.id.remove)
                val et: EditText = layout1.findViewById(R.id.count_gadget)
                val spin: Spinner = layout1.findViewById(R.id.spin5)
                val res: TextView = findViewById(R.id.result4)

                gadgets(spin, wt)

                //ОБРАБОТКА КНОПКИ УДАЛЕНИЯ ПОМЕЩЕНИЯ

                remove.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        count--
                        try {
                            res.setText("${(res.text.toString().toFloat() -  wt.text.toString().toInt() * et.text.toString().toInt()).toInt()}")
                            total -= wt.text.toString().toInt() * et.text.toString().toInt()
                        }catch (e: java.lang.Exception) {}
                        AllEditText.remove(layout)
                        container.removeView(layout)
                    }
                })

                AllEditText.add(layout)
                container.addView(layout)
                count ++
            }
        })

        val spin6: Spinner = findViewById(R.id.spin6)
        val otoplenie: EditText = findViewById(R.id.otoplenie)

        val intens_otoplenie = arrayOf("Отсутствует", "Слабое отопление", "Умеренное отопление", "Интенсивное отопление")

        spin6.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, intens_otoplenie)
        spin6.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long ) {
                if (intens_otoplenie[position] == "Слабое отопление"){
                    otoplenie.setText("80")
                }
                else if(intens_otoplenie[position] == "Умеренное отопление"){
                    otoplenie.setText("100")
                }
                else if(intens_otoplenie[position] == "Интенсивное отопление"){
                    otoplenie.setText("125")
                }
                else if(intens_otoplenie[position] == "Отсутствует") {
                    otoplenie.setText("0")
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                otoplenie.setText("0")
            }

        }

        val spin7: Spinner = findViewById(R.id.spin7)
        val sun_rad: TextView = findViewById(R.id.sun_radiation)

        val q = arrayOf("Мало солнца в помещении","Среднее кол-во солнца в помещении", "Много солнца в помещении")

        spin7.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, q)
        spin7.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long ) {
                if (q[position] == "Мало солнца в помещении"){
                    sun_rad.setText("30")
                }
                else if(q[position] == "Среднее кол-во солнца в помещении"){
                    sun_rad.setText("35")
                }
                else if(q[position] == "Много солнца в помещении"){
                    sun_rad.setText("40")
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }

        val count_gadget1: EditText = findViewById(R.id.count_gadget1)

        val result5: TextView = findViewById(R.id.result5)
        val b3: Button = findViewById(R.id.b3)
        val hight: EditText = findViewById(R.id.hight)

        // ОБРАБОТКА КНОПКИ РАССЧЕТА ОБЪЕМА

        b3.setOnClickListener {
            //ОБРАБОТКА СЛОЖЕНИЯ ДИНАМИЧЕСКИ СОЗДАННЫХ LINEARLAYOUTов
            try {
                for (i in 0 until count) {
                    total += AllEditText.get(i).findViewById<TextView>(R.id.wt1).text.toString()
                        .toFloat() * AllEditText.get(i)
                        .findViewById<EditText>(R.id.count_gadget).text.toString().toFloat()
                }
            }catch (e: Exception) {result4.setText("Некорректный ввод данных")}

            try {
                val a = wt.text.toString().toFloat()
                val b = count_gadget1.text.toString().toFloat()

                result4.setText("${((a * b) + total).toInt()}")
            } catch (e: java.lang.Exception) {
                result4.setText("error")
            }
            total = 0F
            try {
                val human = result3.text.toString().toFloat() * kol_vo_chelov2.text.toString().toFloat()
                val svet = osveshenie.text.toString().toFloat() * ploshad.text.toString().toFloat()
                val heat = otoplenie.text.toString().toFloat() * ploshad.text.toString().toFloat()
                val gadgets = result4.text.toString().toFloat()
                val sun = sun_rad.text.toString().toFloat()* ploshad.text.toString().toFloat() * hight.text.toString().toFloat()

                val volume3 = ((human + svet + heat + gadgets + sun) / 1000)
                val volMin = ("%.1f".format(volume3 * 0.95))
                val volMax = ("%.1f".format(volume3 * 1.15))

                result5.setText(volMin + " - " + volMax)
                kvt.setText("кВт")

            }catch (e: Exception) {result5.setText("Некорректный ввод данных"); kvt.setText("")}
        }



    }

    fun gadgets (spinner: Spinner, textView: TextView){

        val gadgets = arrayOf("Компьютер", "Кофемашина", "Принтер", "Сервер", "Телевизор", "Холодильник")

        spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gadgets)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long ) {
                if (gadgets[position] == "Компьютер" || gadgets[position] == "Принтер"){
                    textView.setText("400")
                }
                else if(gadgets[position] == "Кофемашина"){
                    textView.setText("300")
                }
                else if(gadgets[position] == "Сервер"){
                    textView.setText("750")
                }
                else if(gadgets[position] == "Телевизор" || gadgets[position] == "Холодильник"){
                    textView.setText("150")
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }
    }
}