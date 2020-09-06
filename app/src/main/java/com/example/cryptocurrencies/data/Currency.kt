package com.example.cryptocurrencies.data

data class Currency(
    val id: String,
    val symbol: String,
    val name: String,
    val image: String,
    val currentPrice: Float,
    val marketCapitalization: String,
    val marketCapitalizationRank: Int,
    val totalVolume: Float,
    val priceDayChangePercentage: Float,
    val marketDayChangeCapitalization: Float,
    val circulatingSupply: Double,
    val totalSupply: Double,
    val ath: Float,
    val athChangePercentage: Float
)