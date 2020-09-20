package com.example.cryptocurrencies.mvp.presenter

import com.example.cryptocurrencies.data.Cryptocurrency
import com.example.cryptocurrencies.data.GeckoApi
import com.example.cryptocurrencies.di.App
import com.example.cryptocurrencies.formatThousands
import com.example.cryptocurrencies.mvp.contract.CryptocurrenciesContract
import javax.inject.Inject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import io.reactivex.Observable


class CryptocurrenciesPresenter : CryptocurrenciesContract.Presenter() {
    //внедряем источник данных
    @Inject
    lateinit var geckoApi: GeckoApi

    //инициализируем компоненты Dagger2
    init {
        App.appComponent.inject(this)
    }

    //создаем список, загружая данные с помощью RxJava
    override fun makeList() {
        view.showProgress()
        subscribe(
            geckoApi.getCryptoCurrenciesList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap { Observable.fromIterable(it) }
                .doOnNext {
                    view.addCurrency(
                        Cryptocurrency(
                            it.id,
                            it.symbol,
                            it.name,
                            it.image,
                            it.currentPrice,
                            it.marketCapitalization.formatThousands(),
                            it.marketCapitalizationRank,
                            it.totalVolume,
                            it.priceDayChangePercentage,
                            it.marketDayChangeCapitalization,
                            it.circulatingSupply,
                            it.totalSupply,
                            it.ath,
                            it.athChangePercentage
                        )
                    )
                }
                .doOnComplete {
                    view.hideProgress()
                }
                .subscribe(
                    {
                        view.hideProgress()
                        view.notifyAdapter()
                    }, {
                        view.showErrorMessage(it.message)
                        view.hideProgress()
                        it.printStackTrace()
                    }
                )

        )
    }

    //обновляем список
    override fun refreshList() {
        view.refresh()
        makeList()
    }
}