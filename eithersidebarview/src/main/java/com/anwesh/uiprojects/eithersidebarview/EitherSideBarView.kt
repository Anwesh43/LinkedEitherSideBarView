package com.anwesh.uiprojects.eithersidebarview

/**
 * Created by anweshmishra on 05/08/20.
 */

import android.view.View
import android.view.MotionEvent
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF
import android.app.Activity
import android.content.Context

val colors : Array<String> = arrayOf("#3F51B5", "#009688", "#2196F3", "#4CAF50", "#F44336")
val parts : Int = 4
val scGap : Float = 0.02f / parts
val strokeFactor : Int = 90
val sizeFactor : Float = 3f
val barWidthFactor : Float = 8f
val backColor : Int = Color.parseColor("#BDBDBD")
val delay : Long = 20

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawEitherSideBar(scale : Float, w : Float, h : Float, paint : Paint) {
    val sf : Float = scale.sinify()
    val sf2 : Float = sf.divideScale(1, parts)
    val sf4 : Float = sf.divideScale(3, parts)
    val barW : Float = Math.min(w, h) / barWidthFactor
    val size : Float = Math.min(w, h) / sizeFactor
    save()
    rotate(90f * sf4)
    drawRect(RectF(-size, -barW, -size + 2 * size * sf2, 0f), paint)
    for (j in 0..1) {
        val sfi : Float = sf.divideScale(j, parts)
        save()
        translate(-size + 2 * size * j, -barW)
        drawRect(RectF(0f, -size * sfi, barW, 0f), paint)
        restore()
    }
    restore()
}

fun Canvas.drawESBNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = Color.parseColor(colors[i])
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    save()
    translate(w / 2, h / 2)
    drawEitherSideBar(scale, w, h, paint)
    restore()
}

class EitherSideBarView(ctx : Context) : View(ctx) {

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}