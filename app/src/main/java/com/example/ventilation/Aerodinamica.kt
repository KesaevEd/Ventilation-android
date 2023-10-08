package com.example.ventilation

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import java.lang.String.format
import kotlin.math.pow


class Aerodinamica : AppCompatActivity() {

    private val USERID = 6000
    private var countID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aerodinamica)

        val nember: TextView = findViewById(R.id.number)
        val rashod: EditText = findViewById(R.id.rashod)
        val lenght: EditText = findViewById(R.id.lenght)
        val cut: TextView = findViewById(R.id.cut)
        val spin_sechenie: Spinner = findViewById(R.id.spin_sechenie)
        val spin: Spinner = findViewById(R.id.spin)
        val mest_sopr: TextView = findViewById(R.id.mest_sopr)
        val container1: LinearLayout = findViewById(R.id.container1)
        val container2: LinearLayout = findViewById(R.id.container2)
        val plus1: Button = findViewById(R.id.plus1)
        val plus2: Button = findViewById(R.id.plus2)
        val calculation: Button = findViewById(R.id.calculation)
        val result: TextView = findViewById(R.id.result)
        val rec_cut: TextView = findViewById(R.id.rec_cut)
        val pa: TextView = findViewById(R.id.pa)

        var count = 0
        var count2 = 0

        var total1: Float = 0F
        var total2:Float = 0F
        var total_mestSopr = 0F

        val AllEditText = ArrayList<View>()
        val AllEditText2 = ArrayList<View>()
        val AllEditText3 = ArrayList<View>()
        val AllList = ArrayList<ArrayList<View>>()
        val AllNumbers = ArrayList<TextView>()

        sizes(spin_sechenie, cut)
        mest_sopr(spin, mest_sopr)


        plus1.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                val layout = getLayoutInflater().inflate(R.layout.fragment_aero2, null)
                val layout1: ConstraintLayout = layout.findViewById(R.id.linear1)
                val mest_sopr: TextView = layout1.findViewById(R.id.mest_sopr)
                val spin: Spinner = layout1.findViewById(R.id.spin)
                val remove: Button = layout1.findViewById(R.id.remove)

                mest_sopr(spin, mest_sopr)


                //ОБРАБОТКА КНОПКИ УДАЛЕНИЯ ЭЛЕМЕНТА

                remove.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        count--
                        try {
                            mest_sopr.setText("${(mest_sopr.text.toString().toFloat() -  mest_sopr.text.toString().toInt() * mest_sopr.text.toString().toInt()).toInt()}")
                            total2 -= mest_sopr.text.toString().toFloat()
                        }catch (e: Exception) {}
                        AllEditText.remove(layout)
                        container1.removeView(layout)
                    }
                })

                AllEditText3.add(layout)
                container1.addView(layout)
                count ++
            }
        })




        plus2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                val layout = getLayoutInflater().inflate(R.layout.fragment_aero1, null)
                val layout1: LinearLayout = layout.findViewById(R.id.linearLayout_fragment1)
                val number: TextView = layout1.findViewById(R.id.number)
                val rashod: EditText = layout1.findViewById(R.id.rashod)
                val length: EditText = layout1.findViewById(R.id.lenght)
                val linearLayout_AB: LinearLayout = layout1.findViewById(R.id.linearLayout_AB)
                val cut: TextView = linearLayout_AB.findViewById(R.id.cut)
                val spin_sechenie: Spinner = linearLayout_AB.findViewById(R.id.spin_sechenie)
                val linear_spin: ConstraintLayout = layout1.findViewById(R.id.linear_spin)
                val mest_sopr: TextView = linear_spin.findViewById(R.id.mest_sopr)
                val spin: Spinner = linear_spin.findViewById(R.id.spin)
                val add: LinearLayout = layout1.findViewById(R.id.linearLayout_addElement_container)
                val container1: LinearLayout = layout1.findViewById(R.id.container1)
                val plus: Button = layout1.findViewById(R.id.plus)
                val remove: Button = layout1.findViewById(R.id.remove)
                val recCut: LinearLayout = layout.findViewById(R.id.rec_cut_layout)
                val rec_cut: TextView = recCut.findViewById(R.id.rec_cut)

                sizes(spin_sechenie, cut)
                mest_sopr(spin, mest_sopr)

                layout.id = USERID + countID

                plus.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {


                        val layout = getLayoutInflater().inflate(R.layout.fragment_aero2, null)
                        val layout1: ConstraintLayout = layout.findViewById(R.id.linear1)
                        val mest_sopr: TextView = layout1.findViewById(R.id.mest_sopr)
                        val spin: Spinner = layout1.findViewById(R.id.spin)
                        val remove: Button = layout1.findViewById(R.id.remove)

                        mest_sopr(spin, mest_sopr)


                        //ОБРАБОТКА КНОПКИ УДАЛЕНИЯ ЭЛЕМЕНТА

                        remove.setOnClickListener(object : View.OnClickListener {
                            override fun onClick(v: View?) {

                                try {
                                    mest_sopr.setText("${(mest_sopr.text.toString().toFloat() -  mest_sopr.text.toString().toInt() * mest_sopr.text.toString().toInt()).toInt()}")
                                    total2 -= mest_sopr.text.toString().toFloat()
                                }catch (e: Exception) {}
                                AllEditText.remove(layout)
                                container1.removeView(layout)
                            }
                        })

                        AllEditText.add(layout)
                        container1.addView(layout)
                    }
                })

                //ОБРАБОТКА КНОПКИ УДАЛЕНИЯ УЧАСТКА

                remove.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        count2--
                        try {
                            total1 -= mest_sopr.text.toString().toFloat()
                        }catch (e: Exception) {}
                        AllEditText.remove(layout)
                        container2.removeView(layout)
                        AllNumbers.remove(number)
                        number_count(count2, AllNumbers)
                    }
                })


                AllEditText2.add(layout)
                container2.addView(layout)
                count2 ++
                AllNumbers.add(number)
                number_count(count2, AllNumbers)
                AllList.add(AllEditText)
            }
        })

        calculation.setOnClickListener {

            try {
                total1 = 0.0F
                total2 = 0.0F
                total_mestSopr = 0.0F
                var Frasch = 0F
                var a = 0F
                var b = 0F
                var Dekv = 0F
                var Vfakt: Double = 0.0
                var Re = 0.0
                var lamda = 0.0
                var Pdin = 0F
                var r = 0F
                var Ptren = 0F
                var Psum: Float = 0F

                for (i in 0 until count2) {


                    total1 += AllEditText2.get(i)
                        .findViewById<TextView>(R.id.mest_sopr).text.toString().toFloat()

                    Frasch =
                        AllEditText2.get(i).findViewById<EditText>(R.id.rashod).text.toString()
                            .toFloat() / 18000
                    podbor_cut(Frasch, AllEditText2.get(i).findViewById(R.id.rec_cut))

                    val AB = AllEditText2.get(i).findViewById<TextView>(R.id.cut).text.toString()
                        .split("*")
                    a = AB[0].toFloat()
                    b = AB[1].toFloat()
                    Dekv = ((2 * a * b) / (1000 * (a + b))).toFloat()
                    Vfakt =
                        AllEditText2.get(i).findViewById<EditText>(R.id.rashod).text.toString()
                            .toFloat() / (a * b * 0.0036)
                    Re = 64100 * Vfakt * Dekv
                    lamda = 0.11 * (0.1 / Dekv + 68 / Re).pow(0.25)
                    Pdin = ((Vfakt * Vfakt * 1.2) / 2).toFloat()
                    r = ((1 / Dekv) * Pdin).toFloat()
                    Ptren = ((lamda * AllEditText2.get(i)
                        .findViewById<EditText>(R.id.lenght).text.toString()
                        .toFloat() * Pdin) / Dekv).toFloat()

                    total2 += Ptren
                    Psum += Pdin

                    for (a in 0 until AllList[i].size) {
                        total1 += AllList[i].get(a)
                            .findViewById<TextView>(R.id.mest_sopr).text.toString().toFloat()
                    }
                    total_mestSopr += total1 * Pdin
                }

                var total3: Float = 0F
                var a2 = 0F
                var b2 = 0F
                var Dekv2 = 0F
                var Vfakt2: Double = 0.0
                var Re2 = 0.0
                var lamda2 = 0.0
                var Pdin2 = 0F
                var r2 = 0F
                var Ptren2 = 0F

                Frasch = rashod.text.toString().toFloat() / 18000
                podbor_cut(Frasch, rec_cut)

                val AB2 = cut.text.toString().split("*")
                a2 = AB2[0].toFloat()
                b2 = AB2[1].toFloat()
                Dekv2 = ((2 * a2 * b2) / (1000 * (a2 + b2))).toFloat()
                Vfakt2 = rashod.text.toString().toFloat() / (a2 * b2 * 0.0036)
                Re2 = 64100 * Vfakt2 * Dekv2
                lamda2 = 0.11 * (0.1 / Dekv2 + 68 / Re2).pow(0.25)
                Pdin2 = ((Vfakt2 * Vfakt2 * 1.2) / 2).toFloat()
                r2 = ((1 / Dekv2) * Pdin2).toFloat()
                Ptren2 = ((lamda2 * lenght.text.toString().toFloat() * Pdin2) / Dekv2).toFloat()


                for (i in 0 until AllEditText3.size) {
                    total3 += AllEditText3.get(i)
                        .findViewById<TextView>(R.id.mest_sopr).text.toString().toFloat()
                }

                total3 += mest_sopr.text.toString().toFloat()

                total_mestSopr += total3 * Pdin2


                var Ppoln = Ptren2 + total2 + total_mestSopr

                result.setText(format("%.1f", Ppoln))
                pa.setText("Па")

            }catch (e: Exception) {result.setText("Некорректный ввод данных")}
        }

    }

    fun sizes (spinner: Spinner, textView: TextView){

        val sizes = arrayOf("100*100/d100", "100*200/d133", "100*300/d150", "100*400/d160", "100*500/d167", "100*600/d171", "150*150/d150", "200*150/d171", "250*150/d189", "300*150/d200", "400*150/d218", "500*150/d231", "600*150/d240", "700*150/d247", "800*150/d253", "200*200/d200", "300*200/d240", "400*200/d267", "500*200/d286", "600*200/d300", "700*200/d311", "800*200/d320", "900*200/d327", "1000*200/d333", "300*300/d300", "400*300/d343", "500*300/d375", "600*300/d400", "700*300/d420", "800*300/d436", "900*300/d450", "1000*300/d462", "1200*1600/d1370")

        spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sizes)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long ) {

                val selected = sizes[position]
                val LisSelected = selected.split("/")
                textView.setText(LisSelected[0])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }
    }

    fun mest_sopr (spinner: Spinner, textView: TextView){

        val sizes = arrayOf("Отвод 30° - 3.2", "Отвод 45° - 2.6", "Отвод 60° - 2.2", "Отвод 90° - 1.2", "Отвод 120° - 0.56", "Отвод 150° - 0.16", "Колено Z-образное 90° - 4", "Колено П-образное 90° - 2.3", "Тройник на проходе (нагнетание) - 0.3", "Тройник на проходе (всасывание) - 0.75", "Тройник на ответвлении (нагнетание) - 1.3", "Тройник на ответвлении (всасывание) - 0.4", "Диффузор конический - 0.2", "Диффузор пирамидальный - 0.24", "Конфузор - 0.3", "Расширение - 1", "Сужение - 0.5", "Конический коллектор - 0.4", "Прямой канал с сеткой или решеткой - 1.4", "Первое боковое отверстие - 3.5", "Среднее боковое отверстие - 1.3", "Последнее боковое отверстие - 4.5", "Приточная шахта с зонтом - 1.3", "Приточная шахта с зонтом - 1.2", "Решетка щелевая типа Р - 2", "Воздухораспределитель для подачи воздуха компактной струей типа ВГК - 1.9", "Воздухораспределитель приколонный регулируемый типа НРВ - 3", "Воздухораспределитель для сосредоточенной подачи воздуха типа ВСП - 2.5", "Воздухораспределитель регулируемого типа ВР - 1.6", "Решетка унифицированная типа РВ - 1.9", "Воздухораспределитель вихревой регулируемый типа ВВР - 1.75", "Дроссель клапан - 5", "Шибер - 3", "Диафрагма на прямом участке - 0.7", "Плафон (анемостат) СТ-КР, СТ-КВ - 5.6", "Решетка регулируемая РС-ВГ (приточная) - 3.8", "Решетка нерегулируемая РС-Г - 2.9")

        spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sizes)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long ) {

                val selected = sizes[position]
                val list = selected.split(" - ")
                textView.setText(list[1])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }
    }

    fun podbor_cut (int: Float, textView: TextView) {

        val sizes = arrayOf(
            "100*100",
            "100*200",
            "100*300",
            "100*400",
            "100*500",
            "100*600",
            "150*150",
            "200*150",
            "300*150",
            "400*150",
            "500*150",
            "600*150",
            "700*150",
            "800*150",
            "200*200",
            "300*200",
            "400*200",
            "500*200",
            "600*200",
            "700*200",
            "800*200",
            "900*200",
            "1000*200",
            "300*300",
            "400*300",
            "500*300",
            "600*300",
            "700*300",
            "800*300",
            "900*300",
            "1000*300",
            "1200*1600"
        )

        try {
            for (i in 0 until sizes.size) {
                val b =
                    ((sizes[i].split("*")[0].toFloat() / 1000).toFloat() * (sizes[i].split("*")[1].toFloat() / 1000))
                if (i == 0 && int < b) {
                    textView.setText(sizes[0])
                } else if ((i == sizes.size - 1) && (int > b)) {
                    textView.setText(sizes[sizes.size - 1])
                } else if ((sizes[i].split("*")[0].toFloat() / 1000) * (sizes[i].split("*")[1].toFloat() / 1000) < int && int < (sizes[i + 1].split(
                        "*"
                    )[0].toFloat() / 1000) * (sizes[i + 1].split("*")[1].toFloat() / 1000)
                ) {
                    if ((int - ((sizes[i].split("*")[0].toFloat() / 1000) * (sizes[i].split("*")[1].toFloat() / 1000))) < (((sizes[i + 1].split(
                            "*"
                        )[0].toFloat() / 1000) * (sizes[i + 1].split("*")[1].toFloat() / 1000)) - int)
                    ) {
                        textView.setText(sizes[i])
                    } else {
                        textView.setText(sizes[i + 1])
                    }
                }
            }

        } catch (e: NumberFormatException) {
            textView.setText("Некорректный ввод данных")
        }

    }

    fun number_count(count: Int, AllNunbers: ArrayList<TextView>) {
        for (i in 0 until count){
            AllNunbers[i].setText("${i + 1}")
        }
    }
}