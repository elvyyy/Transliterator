package transliterator

import scala.annotation.tailrec

object Transliterator {

  def lowerChars: Map[Char, String] = Map(
    'à' -> "à",
    'á' -> "b",
    'â' -> "v",
    'ã' -> "g",
    'ä' -> "d",
    'å' -> "e",
    '¸' -> "yo",
    'æ' -> "zh",
    'ç' -> "z",
    'è' -> "i",
    'é' -> "i",
    'ê' -> "k",
    'ë' -> "l",
    'ì' -> "m",
    'í' -> "n",
    'î' -> "o",
    'ï' -> "p",
    'ð' -> "r",
    'ñ' -> "s",
    'ò' -> "t",
    'ó' -> "yu",
    'ô' -> "f",
    'õ' -> "h",
    'ö' -> "ts",
    '÷' -> "ch",
    'ø' -> "sh",
    'ù' -> "shch",
    'ú' -> "\"",
    'û' -> "y",
    'ü' -> "\'",
    'ý' -> "e",
    'þ' -> "yu",
    'ÿ' -> "ya"
  )

  def upperChars = Map(
    'À' -> "À",
    'Á' -> "B",
    'Â' -> "V",
    'Ã' -> "G",
    'Ä' -> "D",
    'Å' -> "E",
    '¨' -> "Yo",
    'Æ' -> "Zh",
    'Ç' -> "Z",
    'È' -> "I",
    'É' -> "I",
    'Ê' -> "K",
    'Ë' -> "L",
    'Ì' -> "M",
    'Í' -> "N",
    'Î' -> "O",
    'Ï' -> "P",
    'Ð' -> "R",
    'Ñ' -> "S",
    'Ò' -> "T",
    'Ó' -> "Yu",
    'Ô' -> "F",
    'Õ' -> "H",
    'Ö' -> "Ts",
    '×' -> "Ch",
    'Ø' -> "Sh",
    'Ù' -> "Shch",
    'Ú' -> "\"",
    'Û' -> "Y",
    'Ü' -> "\'",
    'Ý' -> "E",
    'Þ' -> "Yu",
    'ß' -> "Ya"
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


