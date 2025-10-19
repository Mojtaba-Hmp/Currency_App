package com.example.currencyapp

data class DataClass(
    var title: String,
    var price: Int,
    var change: Int
)

data class CurrencyInfo(
    val prettyName: String,
    val flagResId: Int
)

val currencyMap = mapOf(
    "usd" to CurrencyInfo("دلار آمریکا", R.drawable.us_flag),
    "eur" to CurrencyInfo("یورو", R.drawable.eu_flag),
    "gbp" to CurrencyInfo("پوند انگلیس", R.drawable.uk_flag),
    "aed" to CurrencyInfo("درهم امارات", R.drawable.uae_flag),
    "inr" to CurrencyInfo("روپیه هند", R.drawable.ind_flag),
    "try" to CurrencyInfo("لیر ترکیه", R.drawable.tur_flag),
    "rub" to CurrencyInfo("روبل روسیه", R.drawable.ru_flag),
    "jpy" to CurrencyInfo("ین ژاپن", R.drawable.ja_flag),
    "cny" to CurrencyInfo("یوان چین", R.drawable.ch_flag),
    "krw" to CurrencyInfo("وون کره جنوبی", R.drawable.ko_flag),
    "chf" to CurrencyInfo("فرانک سوییس", R.drawable.swi_flag),
    "sek" to CurrencyInfo("کرون سوئد", R.drawable.swe_flag),
    "nok" to CurrencyInfo("کرون نروژ", R.drawable.no_flag),
    "aud" to CurrencyInfo("دلار استرالیا", R.drawable.au_flag),
    "cad" to CurrencyInfo("دلار کانادا", R.drawable.ca_flag),
    "iqd" to CurrencyInfo("دینار عراق", R.drawable.ir_flag)
)
