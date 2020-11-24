package com.hackathon.artact.view.fragment

import com.hackathon.artact.R
import com.hackathon.artact.base.BaseFragment
import com.hackathon.artact.databinding.FragmentShopBinding
import com.hackathon.artact.viewmodel.ShopViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class ShopFragment: BaseFragment<FragmentShopBinding, ShopViewModel>() {

    override val viewModel: ShopViewModel
        get() = getViewModel(ShopViewModel::class)

    override val layoutRes: Int
        get() = R.layout.fragment_shop

    override fun observerViewModel() { }

    override fun onResume() {
        super.onResume()
        viewModel.getAllGoods()
    }
}