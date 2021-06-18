package com.example.movie.utils

import java.text.SimpleDateFormat
import java.util.*

class Utils {

    companion object {

        fun parseDateToddMMyyyy(time: String): String {
            val date = SimpleDateFormat("yyyy-MM-dd", Locale.ROOT).parse(time)
            return SimpleDateFormat("dd MMM yyyy", Locale.ROOT).format(date)
        }

    }

}