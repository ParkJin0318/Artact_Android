package com.hackathon.artact.widget.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.hackathon.artact.R
import com.hackathon.artact.databinding.ItemOrderBinding
import com.hackathon.artact.model.Order
import com.hackathon.artact.model.OrderInfo
import com.hackathon.artact.widget.recyclerview.viewmodel.OrderItemViewModel

class OrderAdapter : RecyclerView.Adapter<OrderAdapter.ViewHolder>(){

    private lateinit var orderList : ArrayList<OrderInfo>

    val shortClick = MutableLiveData<Int>()

    fun setList(list : ArrayList<OrderInfo>) {
        if(::orderList.isInitialized) return
        orderList = list
    }

    class ViewHolder(private val binding : ItemOrderBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = OrderItemViewModel()

        fun bind(item: OrderInfo) {
            viewModel.bind(item)
            binding.viewModel = viewModel
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        return ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_order, parent, false))
    }

    override fun getItemCount(): Int {
        return if(::orderList.isInitialized) orderList.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        with(holder) {
            bind(orderList[position])
            itemView.setOnClickListener { shortClick.value = position }
        }
    }
}