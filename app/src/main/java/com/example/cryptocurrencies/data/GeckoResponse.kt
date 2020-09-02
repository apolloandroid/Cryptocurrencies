package com.example.cryptocurrencies.data


data class GeckoCoin(
    val id: String,
    val symbol: String,
    val name: String,
    val image: String,
    val currentPrice: Float,
    val marketCapitalization: Float,
    val marketCapitalizationRank: Int,
    val totalVolume: Float,
    val priceDayChangePercentage: Float,
    val marketDayChangeCapitalization: Float,
    val circulatingSupply: Double,
    val totalSupply: Double,
    val ath: Float,
    val athChangePercentage: Float
)

data class GeckoCoinChart(
    var prives: List<List<Float>>
)