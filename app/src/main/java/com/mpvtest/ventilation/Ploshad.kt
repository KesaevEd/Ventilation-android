package com.mpvtest.ventilation

import android.app.ActionBar
import android.app.AlertDialog
import android.app.Dialog
import android.graphics.ImageFormat
import android.graphics.drawable.Drawable
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.mvptest.ventilation.R
import com.mpvtest.ventilation.Figures.list
import java.nio.file.Files.list
import java.util.Collections.list

class Ploshad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ploshad)



        val add: Button = findViewById(R.id.add)
        val container: LinearLayout = findViewById(R.id.container)
        val choice: TextView = findViewById(R.id.choice)

        var count_f1 = 0
        var count_f2 = 0
        var count_f3 = 0
        var count_f4 = 0
        var count_f5 = 0
        var count_f6 = 0
        var count_f7 = 0
        var count_f8 = 0
        var count_f9 = 0
        var count_f10 = 0
        var count_f11 = 0
        var count_f12 = 0
        var count_f13 = 0
        var count_f14 = 0
        var count_f15 = 0
        var count_f16 = 0
        var count_f17 = 0
        var count_f18 = 0
        var count_f19 = 0
        var count_f20 = 0
        var count_f21 = 0


        val F1 = ArrayList<View>()
        val F2 = ArrayList<View>()
        val F3 = ArrayList<View>()
        val F4 = ArrayList<View>()
        val F5 = ArrayList<View>()
        val F6 = ArrayList<View>()
        val F7 = ArrayList<View>()
        val F8 = ArrayList<View>()
        val F9 = ArrayList<View>()
        val F10 = ArrayList<View>()
        val F11 = ArrayList<View>()
        val F12 = ArrayList<View>()
        val F13 = ArrayList<View>()
        val F14 = ArrayList<View>()
        val F15 = ArrayList<View>()
        val F16 = ArrayList<View>()
        val F17 = ArrayList<View>()
        val F18 = ArrayList<View>()
        val F19 = ArrayList<View>()
        val F20 = ArrayList<View>()
        val F21 = ArrayList<View>()


        //СПиннер выбора элемента
        setupCustomSpinner(choice)

        add.setOnClickListener {
            if (choice.text.toString().toInt() == 0) {
                f1(container, F1)
                count_f1++
            }
            else if (choice.text.toString().toInt() == 1) {
                f2(container, F2)
                count_f2++
            }
            else if (choice.text.toString().toInt() == 2) {
                f3(container, F3)
                count_f3++
            }
            else if (choice.text.toString().toInt() == 3) {
                f4(container, F4)
                count_f4++
            }
            else if (choice.text.toString().toInt() == 4) {
                f5(container, F5)
                count_f5++
            }
            else if (choice.text.toString().toInt() == 5) {
                f6(container, F6)
                count_f6++
            }
            else if (choice.text.toString().toInt() == 6) {
                f7(container, F7)
                count_f7++
            }
            else if (choice.text.toString().toInt() == 7) {
                f8(container, F8)
                count_f8++
            }
            else if (choice.text.toString().toInt() == 8) {
                f9(container, F9)
                count_f9++
            }
            else if (choice.text.toString().toInt() == 9) {
                f10(container, F10)
                count_f10++
            }
            else if (choice.text.toString().toInt() == 10) {
                f11(container, F11)
                count_f11++
            }
            else if (choice.text.toString().toInt() == 11) {
                f12(container, F12)
                count_f12++
            }
            else if (choice.text.toString().toInt() == 12) {
                f13(container, F13)
                count_f13++
            }
            else if (choice.text.toString().toInt() == 13) {
                f14(container, F14)
                count_f14++
            }
            else if (choice.text.toString().toInt() == 14) {
                f15(container, F15)
                count_f15++
            }
            else if (choice.text.toString().toInt() == 15) {
                f16(container, F16)
                count_f16++
            }
            else if (choice.text.toString().toInt() == 16) {
                f17(container, F17)
                count_f17++
            }
            else if (choice.text.toString().toInt() == 17) {
                f18(container, F18)
                count_f18++
            }
            else if (choice.text.toString().toInt() == 18) {
                f19(container, F19)
                count_f19++
            }
            else if (choice.text.toString().toInt() == 19) {
                f20(container, F20)
                count_f20++
            }
            else if (choice.text.toString().toInt() == 20) {
                f21(container, F21)
                count_f21++
            }
        }
    }



    private fun setupCustomSpinner(choice: TextView) {
        val adapter = Spinner_ploshad(this, list!!)
        val spinner: Spinner = findViewById(R.id.spin)

        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long ) {
                val selected = Figures.list!![position]
                choice.setText("${position}")
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }

    fun f1(container: LinearLayout, F: ArrayList<View>) {
        val layout = getLayoutInflater().inflate(R.layout.f1, null)
        val im: ImageView = layout.findViewById(R.id.im)
        val remove: Button = layout.findViewById(R.id.remove)
        val layout1: LinearLayout = layout.findViewById(R.id.layout1)
        val A: EditText = layout1.findViewById(R.id.A)
        val layout2: LinearLayout = layout.findViewById(R.id.layout2)
        val B: EditText = layout2.findViewById(R.id.B)
        val layout3: LinearLayout = layout.findViewById(R.id.layout3)
        val L: EditText = layout3.findViewById(R.id.L)
        val layout4: LinearLayout = layout.findViewById(R.id.layout4)
        val count: EditText = layout4.findViewById(R.id.count)

        im.setOnClickListener {
            onTouch(im)
        }

        remove.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                F.remove(layout)
                container.removeView(layout)
            }
        })

        F.add(layout)
        container.addView(layout)
    }


    fun f2(container: LinearLayout, F: ArrayList<View>) {
        val layout = getLayoutInflater().inflate(R.layout.f2, null)
        val remove: Button = layout.findViewById(R.id.remove)
        val layout1: LinearLayout = layout.findViewById(R.id.layout1)
        val D:EditText = layout1.findViewById(R.id.D)
        val layout2: LinearLayout = layout.findViewById(R.id.layout2)
        val L: EditText = layout2.findViewById(R.id.L)
        val layout3: LinearLayout = layout.findViewById(R.id.layout3)
        val count: EditText = layout3.findViewById(R.id.count)

        val im: ImageView = layout.findViewById(R.id.im)
        im.setOnClickListener {
            onTouch(im)
        }

        remove.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                F.remove(layout)
                container.removeView(layout)
            }
        })

        F.add(layout)
        container.addView(layout)
    }

    fun f3(container: LinearLayout, F: ArrayList<View>) {
        val layout = getLayoutInflater().inflate(R.layout.f3, null)
        val remove: Button = layout.findViewById(R.id.remove)
        val layout1: LinearLayout = layout.findViewById(R.id.layout1)
        val D:EditText = layout1.findViewById(R.id.D)
        val layout2: LinearLayout = layout.findViewById(R.id.layout2)
        val alpha: TextView = layout2.findViewById(R.id.alpha)
        val spin_alpha: Spinner = layout2.findViewById(R.id.spin_alpha)
        val layout3: LinearLayout = layout.findViewById(R.id.layout3)
        val count: EditText = layout3.findViewById(R.id.count)

        val im: ImageView = layout.findViewById(R.id.im)
        im.setOnClickListener {
            onTouch(im)
        }

        alpha(spin_alpha, alpha)

        remove.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                F.remove(layout)
                container.removeView(layout)
            }
        })

        F.add(layout)
        container.addView(layout)
    }

    fun f4(container: LinearLayout, F: ArrayList<View>) {
        val layout = getLayoutInflater().inflate(R.layout.f4, null)
        val remove: Button = layout.findViewById(R.id.remove)
        val layout1: LinearLayout = layout.findViewById(R.id.layout1)
        val A:EditText = layout1.findViewById(R.id.A)
        val layout2: LinearLayout = layout.findViewById(R.id.layout2)
        val B:EditText = layout2.findViewById(R.id.B)
        val layout3: LinearLayout = layout.findViewById(R.id.layout3)
        val alpha: TextView = layout3.findViewById(R.id.alpha)
        val spin_alpha: Spinner = layout3.findViewById(R.id.spin_alpha)
        val layout4: LinearLayout = layout.findViewById(R.id.layout4)
        val count: EditText = layout4.findViewById(R.id.count)

        val im: ImageView = layout.findViewById(R.id.im)
        im.setOnClickListener {
            onTouch(im)
        }

        alpha(spin_alpha, alpha)

        remove.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                F.remove(layout)
                container.removeView(layout)
            }
        })

        F.add(layout)
        container.addView(layout)
    }

    fun f5(container: LinearLayout, F: ArrayList<View>) {
        val layout = getLayoutInflater().inflate(R.layout.f5, null)
        val remove: Button = layout.findViewById(R.id.remove)
        val layout1: LinearLayout = layout.findViewById(R.id.layout1)
        val D:EditText = layout1.findViewById(R.id.D)
        val layout2: LinearLayout = layout.findViewById(R.id.layout2)
        val D1: EditText = layout2.findViewById(R.id.D1)
        val layout3: LinearLayout = layout.findViewById(R.id.layout3)
        val L: EditText = layout3.findViewById(R.id.L)
        val layout4: LinearLayout = layout.findViewById(R.id.layout4)
        val count: EditText = layout4.findViewById(R.id.count)

        val im: ImageView = layout.findViewById(R.id.im)
        im.setOnClickListener {
            onTouch(im)
        }

        remove.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                F.remove(layout)
                container.removeView(layout)
            }
        })

        F.add(layout)
        container.addView(layout)
    }

    fun f6(container: LinearLayout, F: ArrayList<View>) {
        val layout = getLayoutInflater().inflate(R.layout.f6, null)
        val remove: Button = layout.findViewById(R.id.remove)
        val layout1: LinearLayout = layout.findViewById(R.id.layout1)
        val layout11: LinearLayout = layout1.findViewById(R.id.layout11)
        val A:EditText = layout11.findViewById(R.id.A)
        val B: EditText = layout11.findViewById(R.id.B)
        val A1: EditText = layout11.findViewById(R.id.A1)
        val layout12: LinearLayout = layout1.findViewById(R.id.layout12)
        val B1:EditText = layout12.findViewById(R.id.B1)
        val L: EditText = layout12.findViewById(R.id.L)
        val count: EditText = layout12.findViewById(R.id.count)

        val im: ImageView = layout.findViewById(R.id.im)
        im.setOnClickListener {
            onTouch(im)
        }


        remove.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                F.remove(layout)
                container.removeView(layout)
            }
        })

        F.add(layout)
        container.addView(layout)
    }

    fun f7(container: LinearLayout, F: ArrayList<View>) {
        val layout = getLayoutInflater().inflate(R.layout.f7, null)
        val remove: Button = layout.findViewById(R.id.remove)
        val layout1: LinearLayout = layout.findViewById(R.id.layout1)
        val layout11: LinearLayout = layout1.findViewById(R.id.layout11)
        val A:EditText = layout11.findViewById(R.id.A)
        val B: EditText = layout11.findViewById(R.id.B)
        val D: EditText = layout11.findViewById(R.id.D)
        val layout12: LinearLayout = layout1.findViewById(R.id.layout12)
        val L: EditText = layout12.findViewById(R.id.L)
        val count: EditText = layout12.findViewById(R.id.count)

        val im: ImageView = layout.findViewById(R.id.im)
        im.setOnClickListener {
            onTouch(im)
        }


        remove.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                F.remove(layout)
                container.removeView(layout)
            }
        })

        F.add(layout)
        container.addView(layout)
    }

    fun f8(container: LinearLayout, F: ArrayList<View>) {
        val layout = getLayoutInflater().inflate(R.layout.f8, null)
        val remove: Button = layout.findViewById(R.id.remove)
        val layout1: LinearLayout = layout.findViewById(R.id.layout1)
        val D:EditText = layout1.findViewById(R.id.D)
        val layout2: LinearLayout = layout.findViewById(R.id.layout2)
        val L: EditText = layout2.findViewById(R.id.L)
        val layout3: LinearLayout = layout.findViewById(R.id.layout3)
        val count: EditText = layout3.findViewById(R.id.count)

        val im: ImageView = layout.findViewById(R.id.im)
        im.setOnClickListener {
            onTouch(im)
        }

        remove.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                F.remove(layout)
                container.removeView(layout)
            }
        })

        F.add(layout)
        container.addView(layout)
    }

    fun f9(container: LinearLayout, F: ArrayList<View>) {
        val layout = getLayoutInflater().inflate(R.layout.f9, null)
        val remove: Button = layout.findViewById(R.id.remove)
        val layout1: LinearLayout = layout.findViewById(R.id.layout1)
        val A:EditText = layout1.findViewById(R.id.A)
        val layout2: LinearLayout = layout.findViewById(R.id.layout2)
        val B: EditText = layout2.findViewById(R.id.B)
        val layout3: LinearLayout = layout.findViewById(R.id.layout3)
        val L: EditText = layout3.findViewById(R.id.L)
        val layout4: LinearLayout = layout.findViewById(R.id.layout4)
        val count: EditText = layout4.findViewById(R.id.count)

        val im: ImageView = layout.findViewById(R.id.im)
        im.setOnClickListener {
            onTouch(im)
        }

        remove.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                F.remove(layout)
                container.removeView(layout)
            }
        })

        F.add(layout)
        container.addView(layout)
    }

    fun f10(container: LinearLayout, F: ArrayList<View>) {
        val layout = getLayoutInflater().inflate(R.layout.f10, null)
        val remove: Button = layout.findViewById(R.id.remove)
        val layout1: LinearLayout = layout.findViewById(R.id.layout1)
        val D:EditText = layout1.findViewById(R.id.D)
        val layout2: LinearLayout = layout.findViewById(R.id.layout2)
        val d: EditText = layout2.findViewById(R.id.d)
        val layout3: LinearLayout = layout.findViewById(R.id.layout3)
        val l1: EditText = layout3.findViewById(R.id.l1)
        val layout4: LinearLayout = layout.findViewById(R.id.layout4)
        val count: EditText = layout4.findViewById(R.id.count)

        val im: ImageView = layout.findViewById(R.id.im)
        im.setOnClickListener {
            onTouch(im)
        }

        remove.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                F.remove(layout)
                container.removeView(layout)
            }
        })

        F.add(layout)
        container.addView(layout)
    }

    fun f11(container: LinearLayout, F: ArrayList<View>) {
        val layout = getLayoutInflater().inflate(R.layout.f11, null)
        val remove: Button = layout.findViewById(R.id.remove)
        val layout1: LinearLayout = layout.findViewById(R.id.layout1)
        val layout11: LinearLayout = layout1.findViewById(R.id.layout11)
        val A:EditText = layout11.findViewById(R.id.A)
        val B: EditText = layout11.findViewById(R.id.B)
        val L1: EditText = layout11.findViewById(R.id.L1)
        val layout12: LinearLayout = layout1.findViewById(R.id.layout12)
        val D: EditText = layout12.findViewById(R.id.D)
        val count: EditText = layout12.findViewById(R.id.count)

        val im: ImageView = layout.findViewById(R.id.im)
        im.setOnClickListener {
            onTouch(im)
        }


        remove.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                F.remove(layout)
                container.removeView(layout)
            }
        })

        F.add(layout)
        container.addView(layout)
    }

    fun f12(container: LinearLayout, F: ArrayList<View>) {
        val layout = getLayoutInflater().inflate(R.layout.f12, null)
        val remove: Button = layout.findViewById(R.id.remove)
        val layout1: LinearLayout = layout.findViewById(R.id.layout1)
        val layout11: LinearLayout = layout1.findViewById(R.id.layout11)
        val D:EditText = layout11.findViewById(R.id.D)
        val L: EditText = layout11.findViewById(R.id.L)
        val D1: EditText = layout11.findViewById(R.id.D1)
        val layout12: LinearLayout = layout1.findViewById(R.id.layout12)
        val L1: EditText = layout12.findViewById(R.id.L1)
        val count: EditText = layout12.findViewById(R.id.count)

        val im: ImageView = layout.findViewById(R.id.im)
        im.setOnClickListener {
            onTouch(im)
        }


        remove.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                F.remove(layout)
                container.removeView(layout)
            }
        })

        F.add(layout)
        container.addView(layout)
    }

    fun f13(container: LinearLayout, F: ArrayList<View>) {
        val layout = getLayoutInflater().inflate(R.layout.f13, null)
        val remove: Button = layout.findViewById(R.id.remove)
        val layout1: LinearLayout = layout.findViewById(R.id.layout1)
        val layout11: LinearLayout = layout1.findViewById(R.id.layout11)
        val D:EditText = layout11.findViewById(R.id.D)
        val L: EditText = layout11.findViewById(R.id.L)
        val A: EditText = layout11.findViewById(R.id.A)
        val layout12: LinearLayout = layout1.findViewById(R.id.layout12)
        val B:EditText = layout12.findViewById(R.id.B)
        val L1: EditText = layout12.findViewById(R.id.L1)
        val count: EditText = layout12.findViewById(R.id.count)

        val im: ImageView = layout.findViewById(R.id.im)
        im.setOnClickListener {
            onTouch(im)
        }


        remove.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                F.remove(layout)
                container.removeView(layout)
            }
        })

        F.add(layout)
        container.addView(layout)
    }

    fun f14(container: LinearLayout, F: ArrayList<View>) {
        val layout = getLayoutInflater().inflate(R.layout.f14, null)
        val remove: Button = layout.findViewById(R.id.remove)
        val layout1: LinearLayout = layout.findViewById(R.id.layout1)
        val layout11: LinearLayout = layout1.findViewById(R.id.layout11)
        val A:EditText = layout11.findViewById(R.id.A)
        val B: EditText = layout11.findViewById(R.id.B)
        val L: EditText = layout11.findViewById(R.id.L)
        val layout12: LinearLayout = layout1.findViewById(R.id.layout12)
        val D:EditText = layout12.findViewById(R.id.D)
        val L1: EditText = layout12.findViewById(R.id.L1)
        val count: EditText = layout12.findViewById(R.id.count)

        val im: ImageView = layout.findViewById(R.id.im)
        im.setOnClickListener {
            onTouch(im)
        }


        remove.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                F.remove(layout)
                container.removeView(layout)
            }
        })

        F.add(layout)
        container.addView(layout)
    }

    fun f15(container: LinearLayout, F: ArrayList<View>) {
        val layout = getLayoutInflater().inflate(R.layout.f15, null)
        val layout1: LinearLayout = layout.findViewById(R.id.layout1)
        val layout_remove: LinearLayout = layout1.findViewById(R.id.layout_remove)
        val remove: Button = layout_remove.findViewById(R.id.remove)
        val layout11: LinearLayout = layout1.findViewById(R.id.layout11)
        val A:EditText = layout11.findViewById(R.id.A)
        val B: EditText = layout11.findViewById(R.id.B)
        val L: EditText = layout11.findViewById(R.id.L)
        val layout12: LinearLayout = layout1.findViewById(R.id.layout12)
        val A1:EditText = layout12.findViewById(R.id.A1)
        val B1: EditText = layout12.findViewById(R.id.B1)
        val L1: EditText = layout12.findViewById(R.id.L1)
        val count: EditText = layout12.findViewById(R.id.count)

        val im: ImageView = layout.findViewById(R.id.im)
        im.setOnClickListener {
            onTouch(im)
        }


        remove.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                F.remove(layout)
                container.removeView(layout)
            }
        })

        F.add(layout)
        container.addView(layout)
    }

    fun f16(container: LinearLayout, F: ArrayList<View>) {
        val layout = getLayoutInflater().inflate(R.layout.f16, null)
        val remove: Button = layout.findViewById(R.id.remove)
        val layout1: LinearLayout = layout.findViewById(R.id.layout1)
        val D:EditText = layout1.findViewById(R.id.D)
        val layout3: LinearLayout = layout.findViewById(R.id.layout3)
        val count: EditText = layout3.findViewById(R.id.count)

        val im: ImageView = layout.findViewById(R.id.im)
        im.setOnClickListener {
            onTouch(im)
        }

        remove.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                F.remove(layout)
                container.removeView(layout)
            }
        })

        F.add(layout)
        container.addView(layout)
    }

    fun f17(container: LinearLayout, F: ArrayList<View>) {
        val layout = getLayoutInflater().inflate(R.layout.f17, null)
        val remove: Button = layout.findViewById(R.id.remove)
        val layout1: LinearLayout = layout.findViewById(R.id.layout1)
        val A:EditText = layout1.findViewById(R.id.A)
        val layout2: LinearLayout = layout.findViewById(R.id.layout2)
        val B: EditText = layout2.findViewById(R.id.B)
        val layout4: LinearLayout = layout.findViewById(R.id.layout4)
        val count: EditText = layout4.findViewById(R.id.count)

        val im: ImageView = layout.findViewById(R.id.im)
        im.setOnClickListener {
            onTouch(im)
        }

        remove.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                F.remove(layout)
                container.removeView(layout)
            }
        })

        F.add(layout)
        container.addView(layout)
    }

    fun f18(container: LinearLayout, F: ArrayList<View>) {
        val layout = getLayoutInflater().inflate(R.layout.f18, null)
        val remove: Button = layout.findViewById(R.id.remove)
        val layout1: LinearLayout = layout.findViewById(R.id.layout1)
        val layout11: LinearLayout = layout1.findViewById(R.id.layout11)
        val A:EditText = layout11.findViewById(R.id.A)
        val B: EditText = layout11.findViewById(R.id.B)
        val L: EditText = layout11.findViewById(R.id.L)
        val layout12: LinearLayout = layout1.findViewById(R.id.layout12)
        val H: EditText = layout12.findViewById(R.id.H)
        val count: EditText = layout12.findViewById(R.id.count)

        val im: ImageView = layout.findViewById(R.id.im)
        im.setOnClickListener {
            onTouch(im)
        }


        remove.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                F.remove(layout)
                container.removeView(layout)
            }
        })

        F.add(layout)
        container.addView(layout)
    }

    fun f19(container: LinearLayout, F: ArrayList<View>) {
        val layout = getLayoutInflater().inflate(R.layout.f19, null)
        val remove: Button = layout.findViewById(R.id.remove)
        val layout1: LinearLayout = layout.findViewById(R.id.layout1)
        val layout11: LinearLayout = layout1.findViewById(R.id.layout11)
        val A:EditText = layout11.findViewById(R.id.A)
        val B: EditText = layout11.findViewById(R.id.B)
        val L: EditText = layout11.findViewById(R.id.L)
        val layout12: LinearLayout = layout1.findViewById(R.id.layout12)
        val H:EditText = layout12.findViewById(R.id.H)
        val H1: EditText = layout12.findViewById(R.id.H1)
        val count: EditText = layout12.findViewById(R.id.count)

        val im: ImageView = layout.findViewById(R.id.im)
        im.setOnClickListener {
            onTouch(im)
        }


        remove.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                F.remove(layout)
                container.removeView(layout)
            }
        })

        F.add(layout)
        container.addView(layout)
    }

    fun f20(container: LinearLayout, F: ArrayList<View>) {
        val layout = getLayoutInflater().inflate(R.layout.f20, null)
        val remove: Button = layout.findViewById(R.id.remove)
        val layout1: LinearLayout = layout.findViewById(R.id.layout1)
        val layout11: LinearLayout = layout1.findViewById(R.id.layout11)
        val A:EditText = layout11.findViewById(R.id.A)
        val B: EditText = layout11.findViewById(R.id.B)
        val A1: EditText = layout11.findViewById(R.id.A1)
        val layout12: LinearLayout = layout1.findViewById(R.id.layout12)
        val B1:EditText = layout12.findViewById(R.id.B1)
        val H: EditText = layout12.findViewById(R.id.H)
        val count: EditText = layout12.findViewById(R.id.count)

        val im: ImageView = layout.findViewById(R.id.im)
        im.setOnClickListener {
            onTouch(im)
        }


        remove.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                F.remove(layout)
                container.removeView(layout)
            }
        })

        F.add(layout)
        container.addView(layout)
    }

    fun f21(container: LinearLayout, F: ArrayList<View>) {
        val layout = getLayoutInflater().inflate(R.layout.f21, null)
        val remove: Button = layout.findViewById(R.id.remove)
        val layout1: LinearLayout = layout.findViewById(R.id.layout1)
        val layout11: LinearLayout = layout1.findViewById(R.id.layout11)
        val A:EditText = layout11.findViewById(R.id.A)
        val B: EditText = layout11.findViewById(R.id.B)
        val H: EditText = layout11.findViewById(R.id.H)
        val layout12: LinearLayout = layout1.findViewById(R.id.layout12)
        val C1: EditText = layout12.findViewById(R.id.C1)
        val count: EditText = layout12.findViewById(R.id.count)

        val im: ImageView = layout.findViewById(R.id.im)
        im.setOnClickListener {
            onTouch(im)
        }


        remove.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                F.remove(layout)
                container.removeView(layout)
            }
        })

        F.add(layout)
        container.addView(layout)
    }


    fun alpha(spinner: Spinner, result: TextView){

        val corners = arrayOf("-", "15", "30", "45", "60", "90")

        spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, corners)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selected = corners[position]
                result.setText("${position}")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

    }

    fun imageView (im: ImageView, first_params: ViewGroup.LayoutParams, flag: Boolean) {

        if (flag == true) {

            val params = LinearLayout.LayoutParams(500, 500);
            im.setLayoutParams(params)
        }
        im.setOnClickListener {
            im.setLayoutParams(first_params)
        }
    }

    fun onTouch(im: ImageView) {

        // custom dialog
        val dialog = Dialog(this);
        dialog.setContentView(R.layout.custom_dialog_image)

        // set the custom dialog components - text, image and button
        val image:ImageView  = dialog.findViewById(R.id.im)
        val drawable: Drawable = im.drawable
            image.setImageDrawable(drawable)

        // if button is clicked, close the custom dialog
        image.setOnClickListener { dialog.dismiss() }

        dialog.show()
        }

    }





