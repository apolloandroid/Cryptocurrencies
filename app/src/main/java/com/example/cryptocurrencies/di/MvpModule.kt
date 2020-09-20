package com.example.cryptocurrencies.di

import com.example.cryptocurrencies.mvp.presenter.CryptocurrenciesPresenter
import com.example.cryptocurrencies.mvp.presenter.LatestChartPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MvpModule {
    @Singleton
    @Provides
    fun provideCryptocurrenciesPresenter(): CryptocurrenciesPresenter = CryptocurrenciesPresenter()

    @Singleton
    @Provides
    fun provideLatestChartPresenter(): LatestChartPresenter = LatestChartPresenter()
}