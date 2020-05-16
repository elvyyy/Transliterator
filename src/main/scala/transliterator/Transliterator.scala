package transliterator

import scala.annotation.tailrec

object Transliterator {

  def lowerChars: Map[Char, String] = Map(
    'а' -> "а",
    'б' -> "b",
    'в' -> "v",
    'г' -> "g",
    'д' -> "d",
    'е' -> "e",
    'ё' -> "yo",
    'ж' -> "zh",
    'з' -> "z",
    'и' -> "i",
    'й' -> "i",
    'к' -> "k",
    'л' -> "l",
    'м' -> "m",
    'н' -> "n",
    'о' -> "o",
    'п' -> "p",
    'р' -> "r",
    'с' -> "s",
    'т' -> "t",
    'у' -> "yu",
    'ф' -> "f",
    'х' -> "h",
    'ц' -> "ts",
    'ч' -> "ch",
    'ш' -> "sh",
    'щ' -> "shch",
    'ъ' -> "\"",
    'ы' -> "y",
    'ь' -> "\'",
    'э' -> "e",
    'ю' -> "yu",
    'я' -> "ya"
  )

  def upperChars = Map(
    'А' -> "А",
    'Б' -> "B",
    'В' -> "V",
    'Г' -> "G",
    'Д' -> "D",
    'Е' -> "E",
    'Ё' -> "Yo",
    'Ж' -> "Zh",
    'З' -> "Z",
    'И' -> "I",
    'Й' -> "I",
    'К' -> "K",
    'Л' -> "L",
    'М' -> "M",
    'Н' -> "N",
    'О' -> "O",
    'П' -> "P",
    'Р' -> "R",
    'С' -> "S",
    'Т' -> "T",
    'У' -> "Yu",
    'Ф' -> "F",
    'Х' -> "H",
    'Ц' -> "Ts",
    'Ч' -> "Ch",
    'Ш' -> "Sh",
    'Щ' -> "Shch",
    'Ъ' -> "\"",
    'Ы' -> "Y",
    'Ь' -> "\'",
    'Э' -> "E",
    'Ю' -> "Yu",
    'Я' -> "Ya"
  )


  def transliterate(text: String): String = {
    @tailrec
    def loop(text: String, acc: String): String = {
      if (text.isEmpty) return acc
      val char = text.charAt(0)

      lowerChars.get(char) match {
        case None => upperChars.get(char) match {
          case None => loop(text.tail, acc :+ char)
          case Some(latinChar) => loop(text.tail, acc ++ latinChar)
        }
        case Some(latinChar) => loop(text.tail, acc ++ latinChar)
      }
    }
    loop(text, new String())
  }
}


