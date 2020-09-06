package com.example.cryptocurrencies.ui.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<VH : BaseAdapter.BaseViewHolder> : RecyclerView.Adapter<VH>() {
    var items = ArrayList<Any>()

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(items[position])
    }

    fun getItem(position: Int) = items[position]

    fun add(newItem: Any) = items.add(newItem)

    fun add(newItems: List<Any>) = items.addAll(newItems)

    abstract class BaseViewHolder(protected val view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(item: Any?)
    }
}