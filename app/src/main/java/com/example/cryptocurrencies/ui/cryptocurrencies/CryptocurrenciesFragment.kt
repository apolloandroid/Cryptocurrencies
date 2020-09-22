package com.example.cryptocurrencies.ui.cryptocurrencies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.request.transition.Transition
import com.example.cryptocurrencies.R
import com.example.cryptocurrencies.data.Cryptocurrency
import com.example.cryptocurrencies.di.App
import com.example.cryptocurrencies.mvp.contract.CryptocurrenciesContract
import com.example.cryptocurrencies.mvp.presenter.CryptocurrenciesPresenter
import com.example.cryptocurrencies.ui.adapters.BaseAdapter
import com.example.cryptocurrencies.ui.adapters.CurrenciesAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class CryptocurrenciesFragment : BaseCryptocurrenciesFragment(), CryptocurrenciesContract.View {
    @Inject
    lateinit var presenter: CryptocurrenciesPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cryptocurrencies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.appComponent.inject(this)
        presenter.attach(this)
        presenter.makeList()
    }

    override fun onResume() {
        super.onResume()
        presenter.attach(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.detach()
    }

    override fun createAdapterInstance(): BaseAdapter<*> {
        return CurrenciesAdapter()
    }

    override fun addCurrency(cryptocurrency: Cryptocurrency) {
        viewAdapter.add(cryptocurrency)
    }

    override fun notifyAdapter() {
        viewAdapter.notifyDataSetChanged()
    }

    override fun showProgress() {
        requireActivity().progress_loading.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        requireActivity().progress_loading.visibility = View.INVISIBLE
    }

    override fun showErrorMessage(error: String?) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    override fun refresh() {
        viewAdapter.items.clear()
    }
}