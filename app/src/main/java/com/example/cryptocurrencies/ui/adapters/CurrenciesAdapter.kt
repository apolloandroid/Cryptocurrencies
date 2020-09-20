package com.example.cryptocurrencies.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.cryptocurrencies.R
import com.example.cryptocurrencies.data.Cryptocurrency
import kotlinx.android.synthetic.main.cryptocurremcies_list_item.view.*

class CurrenciesAdapter : BaseAdapter<CurrenciesAdapter.CurrencyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cryptocurremcies_list_item, parent, false)
        return CurrencyViewHolder(view)
    }

    class CurrencyViewHolder(view: View) : BaseAdapter.BaseViewHolder(view) {
        init {
            view.setOnClickListener {

            }
        }

        override fun bind(item: Any?) {
            let {
                item as Cryptocurrency
                Glide.with(view.context).load(item.image).into(view.image_cryptocurrency_icon)
                view.apply {
                    text_cryptocurrency_sym.text = item.symbol
                    text_cryptocurrency_name.text = item.name
                    text_cryptocurrency_market_cap.text = item.marketCapitalization
                    text_cryptocurrency_price.text = item.currentPrice.toString()
                }
            }
        }

    }
}