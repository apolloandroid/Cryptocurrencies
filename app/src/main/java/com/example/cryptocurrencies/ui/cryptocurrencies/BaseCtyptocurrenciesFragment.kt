package com.example.cryptocurrencies.ui.cryptocurrencies

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_cryptocurrencies.*


abstract class BaseCryptocurrenciesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    protected lateinit var viewAdapter: com.example.cryptocurrencies.ui.adapters.BaseAdapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewManager = LinearLayoutManager(context)
        viewAdapter = createAdapterInstance()

        recyclerView = list_cryptocurrencies.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    abstract fun createAdapterInstance(): com.example.cryptocurrencies.ui.adapters.BaseAdapter<*>
}