package com.example.cryptocurrencies.di

import android.app.Application

class App : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeAppComponent()
    }

    private fun initializeAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .restModule(RestModule())
            .mvpModule(MvpModule())
            .chartModule(ChartModule())
            .build()
    }
}