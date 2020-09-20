package com.example.cryptocurrencies.di

import com.example.cryptocurrencies.MainActivity
import com.example.cryptocurrencies.mvp.presenter.CryptocurrenciesPresenter
import com.example.cryptocurrencies.mvp.presenter.LatestChartPresenter
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = arrayOf(
        AppModule::class,
        ChartModule::class,
        MvpModule::class,
        RestModule::class
    )
)
@Singleton
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(cryptocurrenciesPresenter: CryptocurrenciesPresenter)
    fun inject(latestChartPresenter: LatestChartPresenter)
}