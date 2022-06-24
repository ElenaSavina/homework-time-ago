package ru.netology

const val MINUTE = 60
const val HOUR = 3_600
const val DAY = 86_400
const val TWO_DAYS = 172_800
const val THREE_DAYS = 259_200

fun main() {
    val secondsAgoOnline = 3_601

    println(agoToText(secondsAgoOnline))
}

fun agoToText(secondsAgoOnline: Int): String {
    return when {
        secondsAgoOnline <= MINUTE -> "был(а) только что"
        secondsAgoOnline <= HOUR -> formatTime(
            secondsAgoOnline, "минуту", "минуты", "минут"
        )
        secondsAgoOnline <= DAY -> formatTime(
            secondsAgoOnline, "час", "часа", "часов"
        )
        secondsAgoOnline <= TWO_DAYS -> "был(а) сегодня"
        secondsAgoOnline <= THREE_DAYS -> "был(а) вчера"
        else -> "был(а) давно"
    }
}

fun formatTime(
    seconds: Int,
    wordFormTime1: String,
    wordFormTime2: String,
    wordFormTime3: String,
): String {
    val time = if (seconds <= HOUR) (seconds / MINUTE) else (seconds / HOUR)
    val formTime = when {
        (time % 10 == 1 && time != 11) -> wordFormTime1
        (time % 10 == 2 && time != 12) || (time % 10 == 3 && time != 13) || (time % 10 == 4 && time != 14) -> wordFormTime2
        else -> wordFormTime3
    }
    return "был(а) в сети $time $formTime назад"
}