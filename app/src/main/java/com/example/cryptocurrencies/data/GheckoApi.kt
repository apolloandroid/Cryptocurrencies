package com.example.cryptocurrencies.data

import retrofit2.http.Query
import java.util.*

interface GheckoApi {

    fun getCryptoCurrenciesList(
        @Query("vsCurrency") vs: String = "usd",
        @Query("per_page") perPages: Int = 100,
        @Query("sparkline") sparkLine: Boolean = false,
        @Query("order") order: String = "marketcap_desc",
    ): Observable<List<GeckoCoin>>
}