package io.iskaldvind.translator

import io.iskaldvind.model.data.userdata.Meaning
import io.iskaldvind.model.data.userdata.TranslatedMeaning
import io.iskaldvind.translator.utils.convertMeaningsToSingleString
import org.junit.Assert.*
import org.junit.Test

class SearchResultParserTest {

    private val meaningsMock = listOf(
        Meaning(TranslatedMeaning("Meaning1")),
        Meaning(TranslatedMeaning("Meaning2"))
    )

    @Test
    fun convertMeaningsToSingleString_CorrectMeanings_ReturnsEqual() {
        assertEquals(convertMeaningsToSingleString(meaningsMock), "Meaning1, Meaning2")
    }

    @Test
    fun convertMeaningsToSingleString_EmptyMeanings_ReturnsEqual() {
        assertEquals(convertMeaningsToSingleString(listOf<Meaning>()), "")
    }

    @Test
    fun convertMeaningsToSingleString_CorrectMeanings_ReturnsNotEmpty() {
        assertNotEquals(convertMeaningsToSingleString(meaningsMock), "")
    }

    @Test
    fun convertMeaningsToSingleString_CorrectMeanings_ReturnsNotNull() {
        assertNotNull(convertMeaningsToSingleString(meaningsMock))
    }

    @Test
    fun convertMeaningsToSingleString_CorrectMeanings_ReturnsEquals() {
        assertEquals(convertMeaningsToSingleString(meaningsMock), convertMeaningsToSingleString(meaningsMock))
    }
}