package transliterator

import scala.annotation.tailrec

object Transliterator {

  def lowerChars: Map[Char, String] = Map(
    '�' -> "�",
    '�' -> "b",
    '�' -> "v",
    '�' -> "g",
    '�' -> "d",
    '�' -> "e",
    '�' -> "yo",
    '�' -> "zh",
    '�' -> "z",
    '�' -> "i",
    '�' -> "i",
    '�' -> "k",
    '�' -> "l",
    '�' -> "m",
    '�' -> "n",
    '�' -> "o",
    '�' -> "p",
    '�' -> "r",
    '�' -> "s",
    '�' -> "t",
    '�' -> "yu",
    '�' -> "f",
    '�' -> "h",
    '�' -> "ts",
    '�' -> "ch",
    '�' -> "sh",
    '�' -> "shch",
    '�' -> "\"",
    '�' -> "y",
    '�' -> "\'",
    '�' -> "e",
    '�' -> "yu",
    '�' -> "ya"
  )

  def upperChars = Map(
    '�' -> "�",
    '�' -> "B",
    '�' -> "V",
    '�' -> "G",
    '�' -> "D",
    '�' -> "E",
    '�' -> "Yo",
    '�' -> "Zh",
    '�' -> "Z",
    '�' -> "I",
    '�' -> "I",
    '�' -> "K",
    '�' -> "L",
    '�' -> "M",
    '�' -> "N",
    '�' -> "O",
    '�' -> "P",
    '�' -> "R",
    '�' -> "S",
    '�' -> "T",
    '�' -> "Yu",
    '�' -> "F",
    '�' -> "H",
    '�' -> "Ts",
    '�' -> "Ch",
    '�' -> "Sh",
    '�' -> "Shch",
    '�' -> "\"",
    '�' -> "Y",
    '�' -> "\'",
    '�' -> "E",
    '�' -> "Yu",
    '�' -> "Ya"
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


