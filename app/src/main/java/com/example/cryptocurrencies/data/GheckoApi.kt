package com.example.cryptocurrencies.data

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

interface GeckoApi {
    @GET("coins/markets")
    fun getCryptoCurrenciesList(
        @Query("vsCurrency") vs: String = "usd",
        @Query("per_page") perPage: Int = 100,
        @Query("sparkline") sparkLine: Boolean = false,
        @Query("order") order: String = "market_cap_desc",
    ): Observable <List<GeckoCoin>>


    fun getCoinMarketChart(
        @Path ("id") id:String,
        @Query("vsCurrency") vsCurrency:String = "use",
        @Query("days") days:String = "market_cap_desc"
    ) : Obser
}