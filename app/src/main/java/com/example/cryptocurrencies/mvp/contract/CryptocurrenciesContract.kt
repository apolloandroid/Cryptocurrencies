package com.example.cryptocurrencies.mvp.contract

import com.example.cryptocurrencies.data.Cryptocurrency

class CryptocurrenciesContract {
    interface View : BaseContract.View {
        fun addCurrency(cryptocurrency: Cryptocurrency)
        fun notifyAdapter()
        fun showProgress()
        fun hideProgress()
        fun showErrorMessage(error: String?)
        fun refresh()
    }

    abstract class Presenter : BaseContract.Presenter<View>() {
        abstract fun makeList()
        abstract fun refreshList()
    }
}