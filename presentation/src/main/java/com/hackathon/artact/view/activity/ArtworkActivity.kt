package com.hackathon.artact.view.activity

import com.hackathon.artact.R
import com.hackathon.artact.base.BaseActivity
import com.hackathon.artact.databinding.ActivityArtworkBinding
import com.hackathon.artact.viewmodel.ArtworkViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class ArtworkActivity : BaseActivity<ActivityArtworkBinding, ArtworkViewModel>() {

    override val viewModel: ArtworkViewModel
        get() = getViewModel(ArtworkViewModel::class)

    override val layoutRes: Int
        get() = R.layout.activity_artwork

    override fun observerViewModel() {

    }
}