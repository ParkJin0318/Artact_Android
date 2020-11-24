package com.hackathon.artact.widget.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.hackathon.artact.R
import com.hackathon.artact.databinding.ItemGoodsBinding
import com.hackathon.artact.model.Goods
import com.hackathon.artact.widget.recyclerview.viewmodel.GoodsItemViewModel

class GoodsAdapter : RecyclerView.Adapter<GoodsAdapter.ViewHolder>(){

    private lateinit var artworkList : ArrayList<Goods>

    val shortClick = MutableLiveData<Int>()

    fun setList(list : ArrayList<Goods>) {
        if(::artworkList.isInitialized) return
        artworkList = list
    }

    class ViewHolder(private val binding : ItemGoodsBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = GoodsItemViewModel()

        fun bind(item: Goods) {
            viewModel.bind(item)
            binding.viewModel = viewModel
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        return ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_goods, parent, false))
    }

    override fun getItemCount(): Int {
        return if(::artworkList.isInitialized) artworkList.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        with(holder) {
            bind(artworkList[position])
            itemView.setOnClickListener { shortClick.value = position }
        }
    }
}