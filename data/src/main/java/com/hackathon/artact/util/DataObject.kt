package com.hackathon.artact.util

import com.hackathon.artact.model.Artwork
import com.hackathon.artact.model.Goods

object DataObject {
    private lateinit var artwork: Artwork
    private lateinit var goods: Goods

    fun setArtwork(artwork: Artwork) {
        this.artwork = artwork
    }

    fun getArtwork(): Artwork {
        return artwork
    }

    fun setGoods(goods: Goods) {
        this.goods = goods
    }

    fun getGoods(): Goods {
        return goods
    }
}