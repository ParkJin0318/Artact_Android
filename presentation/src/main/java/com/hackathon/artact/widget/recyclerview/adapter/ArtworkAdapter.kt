package com.hackathon.artact.widget.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.hackathon.artact.R
import com.hackathon.artact.databinding.ItemArtworkBinding
import com.hackathon.artact.model.Artwork
import com.hackathon.artact.widget.recyclerview.viewmodel.ArtworkItemViewModel

class ArtworkAdapter : RecyclerView.Adapter<ArtworkAdapter.ViewHolder>(){

    private lateinit var artworkList : ArrayList<Artwork>

    val shortClick = MutableLiveData<Int>()

    fun setList(list : ArrayList<Artwork>) {
        if(::artworkList.isInitialized) return
        artworkList = list
    }

    class ViewHolder(private val binding : ItemArtworkBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = ArtworkItemViewModel()

        fun bind(note: Artwork) {
            viewModel.bind(note)
            binding.viewModel = viewModel
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        return ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_artwork, parent, false))
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