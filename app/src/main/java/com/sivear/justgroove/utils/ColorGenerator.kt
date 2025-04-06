package com.sivear.justgroove.utils

import kotlin.random.Random

fun generateBrightColor(): Int {
    val red = Random.nextInt(150, 256)   // 红色分量 150~255
    val green = Random.nextInt(150, 256) // 绿色分量 150~255
    val blue = Random.nextInt(150, 256)  // 蓝色分量 150~255
    val alpha = 255                      // 不透明

    return (alpha shl 24) or (red shl 16) or (green shl 8) or blue
}