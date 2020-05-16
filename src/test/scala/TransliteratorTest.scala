package transliterator

import org.junit.{Assert, Rule, Test}

/*
 *  This class is a test suite for the methods in object Transliterator.
 */
class TransliteratorTest {

  import transliterator.Transliterator._

  trait TranslitData {

    val s1 = new String("привет")

    val str1 = new String("Эта книга адресована всем, кто изучает русский язык. Но состоит она не из правил, " +
      "упражнений и учебных текстов. Для этого созданы другие замечательные учебники.\n\n" +
      "У этой книги совсем иная задача. Она поможет вам научиться не только разговаривать, " +
      "но и размышлять по-русски. Книга, которую вы держите в руках, составлена из афоризмов " +
      "и размышлений великих мыслителей, писателей, поэтов, философов и общественных деятелей " +
      "различных эпох. Их мысли - о тех вопросах, которые не перестают волновать человечество.\n\n" +
      "Вы можете соглашаться или не соглашаться с тем, что прочитаете в этой книге. Возможно, вам покажется," +
      " что какие-то мысли уже устарели. Но вы должны обязательно подумать и обосновать, почему вы так считаете.\n\n" +
      "А еще вы узнаете и почувствуете, как прекрасно звучат слова любви, сострадания, мудрости и доброты на русском языке.")

    val str2 = new String("Etа knigа аdresovаnа vsem, kto izyuchаet ryusskii yazyk. No sostoit onа ne iz prаvil," +
      " yuprаzhnenii i yuchebnyh tekstov. Dlya etogo sozdаny dryugie zаmechаtel'nye yuchebniki.\n\n" +
      "Yu etoi knigi sovsem inаya zаdаchа. Onа pomozhet vаm nаyuchit'sya ne tol'ko rаzgovаrivаt', no " +
      "i rаzmyshlyat' po-ryusski. Knigа, kotoryuyu vy derzhite v ryukаh, sostаvlenа iz аforizmov i rаzmyshlenii " +
      "velikih myslitelei, pisаtelei, poetov, filosofov i obshchestvennyh deyatelei rаzlichnyh epoh. Ih mysli - o teh" +
      " voprosаh, kotorye ne perestаyut volnovаt' chelovechestvo.\n\nVy mozhete soglаshаt'sya ili ne soglаshаt'sya " +
      "s tem, chto prochitаete v etoi knige. Vozmozhno, vаm pokаzhetsya, chto kаkie-to mysli yuzhe yustаreli. " +
      "No vy dolzhny obyazаtel'no podyumаt' i obosnovаt', pochemyu vy tаk schitаete.\n\nА eshche vy yuznаete " +
      "i pochyuvstvyuete, kаk prekrаsno zvyuchаt slovа lyubvi, sostrаdаniya, myudrosti i dobroty nа ryusskom yazyke.")
  }

  @Test def `привет string test`: Unit =
    new TranslitData {
      Assert.assertEquals(true, "privet" == transliterate(s1))
    }

  @Test def `empty string test`: Unit =
    new TranslitData {
      Assert.assertEquals(true, new String() == transliterate(""))
    }

  @Test def `big text test`: Unit =
    new TranslitData {
      Assert.assertEquals(true, str2 == transliterate(str1))
    }

  @Test def `already transliterated text`: Unit =
    new TranslitData {
      Assert.assertEquals(true, str2 == transliterate(str2))
    }

  @Rule def individualTestTimeout = new org.junit.rules.Timeout(10 * 1000)
}
