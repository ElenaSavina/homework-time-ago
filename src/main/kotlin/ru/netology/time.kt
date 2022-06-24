package ru.netology

const val MINUTE = 60
const val HOUR = 3_600
const val DAY = 86_400
const val TWO_DAYS = 172_800
const val THREE_DAYS = 259_200

fun main() {
    val secondsAgoOnline = 145
    val wasOnline = agoToText(secondsAgoOnline)
    println(wasOnline)
}

fun agoToText(secondsAgoOnline: Int): String {
    return when {
        secondsAgoOnline <= MINUTE -> "был(а) только что"
        secondsAgoOnline <= HOUR -> "был(а) в сети х минут назад"
        secondsAgoOnline <= DAY -> "был(а) в сети x часов назад"
        secondsAgoOnline <= TWO_DAYS -> "был(а) сегодня"
        secondsAgoOnline <= THREE_DAYS -> "был(а) вчера"
        else -> "был(а) давно"
    }
}