package com.mvptest.utils

import android.content.Context
import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.util.Log
import androidx.core.content.FileProvider
import com.mvptest.domain.models.Project
import com.mvptest.domain.models.RoomDetails
import com.mvptest.ventilation.R
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class ShareProjectHelper(val context: Context) {

    private lateinit var increaseY: () -> Unit
    private lateinit var paint: Paint
    private lateinit var canvas: Canvas
    private var currentY = 20f

    fun createPdfFromObject(project: Project, rooms: List<RoomDetails>) {
        val pdfDocument = PdfDocument()

        // Создаем страницу
        val pageInfo = PdfDocument.PageInfo.Builder(300, 600, 1).create()
        val page = pdfDocument.startPage(pageInfo)
        canvas = page.canvas

        increaseY = { currentY += 50f }

        // Рисуем на странице
        paint = Paint()
        paint.textSize = 15f
        canvas.drawText(project.title, 120f, currentY, paint)
        currentY += 30f

        descANdName(
            R.string.project_address,
            project.address,
        )

        descANdName(
            R.string.start_date,
            project.startDate,
        )

        descANdName(
            R.string.contact,
            project.contact,
        )

        descANdName(
            R.string.contact_phone,
            project.contactPhone,
        )

        Log.d("rooms", "project.rooms = $rooms")
        if (rooms.isNotEmpty()) {
            for (room in rooms) {
                paint.textSize = 15f
                canvas.drawText(room.title, 60f, currentY, paint)
                currentY += 30f

                descANdName(
                    desc = R.string.vent_system_number,
                    name = room.systemNumber,
                )
                descANdName(
                    desc = R.string.room_destination,
                    name = room.ventSystemDestination.string,
                )
                descANdName(
                    desc = R.string.start_date,
                    name = room.startDate,
                )
                descANdName(
                    desc = R.string.dead_lines,
                    name = room.deadLines,
                )
                descANdName(
                    desc = R.string.comment_room,
                    name = room.comment,
                )
                descANdName(
                    desc = R.string.air_exchange_performance,
                    name = room.airExchangePerformance,
                )
                descANdName(
                    desc = R.string.air_duct_cross,
                    name = room.airDuctCrossSize,
                )
                descANdName(
                    desc = R.string.pressure_loss,
                    name = room.pressureLoss,
                )
                descANdName(
                    desc = R.string.heater_type,
                    name = room.heaterType.string,
                )
                descANdName(
                    desc = R.string.heater_performance,
                    name = room.heaterPerformance,
                )
                descANdName(
                    desc = R.string.air_conditioner_performance,
                    name = room.airConditionerPerformance,
                )
            }
        }

        // Закрываем страницу и документ
        pdfDocument.finishPage(page)

        // Создаем файл для сохранения документа
        val file = File(context.filesDir, "${project.title}.pdf")

        try {
            // Создаем OutputStream для записи в файл
            val outputStream = FileOutputStream(file)

            // Сохраняем PdfDocument в файл
            pdfDocument.writeTo(outputStream)

            // Закрываем OutputStream
            outputStream.close()

            // Создаем Intent для Sharesheet
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "application/pdf"
            shareIntent.putExtra(
                Intent.EXTRA_STREAM,
                FileProvider.getUriForFile(context, "com.mvptest.ventilation.fileprovider", file),
            )
            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)

            // Запускаем Sharesheet
            context.startActivity(
                Intent.createChooser(
                    shareIntent,
                    context.getString(R.string.send_project),
                ),
            )
        } catch (e: IOException) {
            e.printStackTrace()
        }

        // Закрываем PdfDocument
        pdfDocument.close()
    }

    private fun descANdName(
        desc: Int,
        name: String?,
    ) {
        if (name != null && name != "") {
            paint.textSize = 10f
            paint.color = Color.GRAY
            canvas.drawText(context.getString(desc), 20f, currentY, paint)
            paint.textSize = 13f
            paint.color = Color.BLACK
            canvas.drawText(name, 20f, currentY + 20f, paint)
            increaseY()
        }
    }
}
