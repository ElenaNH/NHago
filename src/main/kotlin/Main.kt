fun main(args: Array<String>) {

    displayWhoWhenWas("Миша", 59uL)
    displayWhoWhenWas("Катя", 60uL)
    displayWhoWhenWas("Вера", 61uL)

    displayWhoWhenWas("Таня", 60uL * 2uL)
    displayWhoWhenWas("Маша", 60uL * 2uL + 1uL)

    displayWhoWhenWas("Оля", 60uL * 5uL)
    displayWhoWhenWas("Петя", 60uL * 5uL + 1uL)

    displayWhoWhenWas("Нина", 60uL * 25uL)
    displayWhoWhenWas("Зина", 60uL * 25uL + 1uL)

    displayWhoWhenWas("Каринэ", 60uL * 60uL)
    displayWhoWhenWas("Армен", 60uL * 60uL + 1uL)

    displayWhoWhenWas("Алексей", 60uL * 60uL * 11uL)
    displayWhoWhenWas("Руслан", 60uL * 60uL * 11uL + 1uL)

    displayWhoWhenWas("Вадим", 60uL * 60uL * 21uL)
    displayWhoWhenWas("Лилия", 60uL * 60uL * 21uL + 1uL)

    displayWhoWhenWas("Наташа", 60uL * 60uL * 22uL)
    displayWhoWhenWas("Костя", 60uL * 60uL * 22uL + 1uL)

    displayWhoWhenWas("Дима", 60uL * 60uL * 24uL)
    displayWhoWhenWas("Ася", 60uL * 60uL * 24uL + 1uL)

    displayWhoWhenWas("Лена", 60uL * 60uL * 48uL)
    displayWhoWhenWas("Виктор", 60uL * 60uL * 48uL + 1uL)

    displayWhoWhenWas("Иван", 60uL * 60uL * 72uL)
    displayWhoWhenWas("Никита", 60uL * 60uL * 72uL + 1uL)


}

fun displayWhoWhenWas(name: String, timeSec: ULong) {
    println(name + " " + agoToText(timeSec))
}

fun agoToText(timeSec: ULong): String {
    val daySec = 86400uL // День (сутки), выраженные в секундах
    val hourSec = 3600uL // Час, выраженный в секундах
    val minSec = 60uL // Минута, выраженная в секундах

    val timeSec1 = timeSec - 1uL // Это подгонка моего понимания времени под описание задачи
    // в моем понимании, если прошло 60 секунд, то прошла одна минута
    // к тому же, нельзя написать "был(а) 24 часа назад или 60 секунд назад, это как-то странно выглядит
    // но мы все сделаем строго по условию, так что выкинем одну секунду для получения нужного текста
    val wholeDays: ULong = timeSec1 / daySec
    val wholeHours: UByte = ((timeSec1 % daySec) / hourSec).toUByte()
    val wholeMin: UByte = ((timeSec1 % hourSec) / minSec).toUByte()
    // val wholeSec: UByte = (timeSec1 % minSec).toUByte() // далее не используется

    val whenWas: String = when {
        wholeDays >= 3uL -> "давно"
        wholeDays >= 2uL -> "позавчера"
        wholeDays >= 1uL -> "вчера"
        wholeHours > 0uL -> attachWordToNumber(wholeHours, "час")
        wholeMin > 0uL -> attachWordToNumber(wholeMin, "минута")
        else -> "только что"
    }

    return "был(а) в сети $whenWas"
}

fun attachWordToNumber(number: UByte, word: String): String {
    return "$number " + when {
        ((number % 10u == 1u) && ((number / 10u) % 10u != 1u)) -> when (word) {
            "час" -> "час"
            "минута" -> "минуту"
            else -> word
        }
    ((number % 10u >= 1u) && (number % 10u <= 4u) && ((number / 10u) % 10u != 1u)) -> when (word) {
        "час" -> "часа"
        "минута" -> "минуты"
        else -> word
    }
      else -> when (word) {
          "час" -> "часов"
          "минута" -> "минут"
          else -> word
      }
    } + " назад"

}