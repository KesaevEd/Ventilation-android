package com.mpvtest.ventilation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.mvptest.ventilation.R

class Spinner_ploshad (context: Context, figureList: List<Figure>) : ArrayAdapter<Figure>(context, 0, figureList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View {

        val figure = getItem(position)

        val view = LayoutInflater.from(context).inflate(R.layout.spinner_custom_ploshad, parent, false)
        val figureImage = view.findViewById<ImageView>(R.id.figureImage)
        figureImage.setImageResource(figure!!.image)

        val figureName = view.findViewById<TextView>(R.id.figureName)
        figureName.text = figure.name

        return view
    }
}