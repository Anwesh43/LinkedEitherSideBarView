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
