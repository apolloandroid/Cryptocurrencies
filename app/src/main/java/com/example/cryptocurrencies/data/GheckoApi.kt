package com.example.cryptocurrencies.data

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import io.reactivex.Observable

interface GeckoApi {
    @GET("coins/markets")
    fun getCryptoCurrenciesList(
        @Query("vsCurrency") vs: String = "usd",
        @Query("per_page") perPage: Int = 100,
        @Query("sparkline") sparkLine: Boolean = false,
        @Query("order") order: String = "market_cap_desc",
    ): Observable<List<GeckoCoin>>

    @GET("coins/{id}/market_chart")
    fun getCoinMarketChart(
        @Path("id") id: String,
        @Query("vsCurrency") vsCurrency: String = "usd",
        @Query("days") days: String = "max"
    ): Observable<GeckoCoinChart>
}