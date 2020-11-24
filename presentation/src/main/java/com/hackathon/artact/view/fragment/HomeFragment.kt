package com.hackathon.artact.view.fragment

import androidx.lifecycle.Observer
import com.hackathon.artact.R
import com.hackathon.artact.base.BaseFragment
import com.hackathon.artact.databinding.FragmentHomeBinding
import com.hackathon.artact.view.activity.ArtworkActivity
import com.hackathon.artact.viewmodel.HomeViewModel
import com.hackathon.artact.widget.extension.startActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

class HomeFragment: BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel
        get() = getViewModel(HomeViewModel::class)

    override val layoutRes: Int
        get() = R.layout.fragment_home

    override fun observerViewModel() {
        with(viewModel) {
            artworkAdapter.shortClick.observe(this@HomeFragment, Observer {
                startActivity(ArtworkActivity::class.java)
            })
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllArtworks()
    }
}