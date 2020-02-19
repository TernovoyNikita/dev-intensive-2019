package ru.skillbranch.devintensive.utils

import java.util.*

object Utils {
    fun parseFullName(fullName: String?):Pair<String?, String?>{
        val parts : List<String>? = fullName?.trim()?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        return (if (firstName == "") null else firstName) to (if (lastName == "") null else lastName)
    }

    fun transliteration(payload: String, devider: String = " "): String {
        val cyrillic = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя "
        val latin = arrayOf("a", "b", "v", "g", "d", "e", "e", "zh", "z", "i", "i",
            "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "f", "h", "c", "ch",
            "sh", "sh'", "", "i", "", "e", "yu", "ya", devider)

        return buildString {
            payload.forEach {
                val i = cyrillic.indexOf(it, ignoreCase = true)
                if (i < 0) append(it)
                else append(if (it.isUpperCase()) latin[i].toUpperCase(Locale.getDefault()) else latin[i])
            }
        }
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        val fN = firstName?.trim()?.firstOrNull()?.toUpperCase()
        val lN = lastName?.trim()?.firstOrNull()?.toUpperCase()
        return if (fN == null && lN == null) null
                else if (lN == null) fN.toString()
                else if (fN == null) lN.toString()
                else fN.toString()+lN
    }
}