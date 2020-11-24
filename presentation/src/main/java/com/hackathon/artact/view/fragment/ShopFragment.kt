package com.hackathon.artact.view.fragment

import androidx.lifecycle.Observer
import com.hackathon.artact.R
import com.hackathon.artact.base.BaseFragment
import com.hackathon.artact.databinding.FragmentShopBinding
import com.hackathon.artact.util.DataObject
import com.hackathon.artact.view.activity.ArtworkActivity
import com.hackathon.artact.view.activity.GoodsActivity
import com.hackathon.artact.viewmodel.ShopViewModel
import com.hackathon.artact.widget.extension.startActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

class ShopFragment: BaseFragment<FragmentShopBinding, ShopViewModel>() {

    override val viewModel: ShopViewModel
        get() = getViewModel(ShopViewModel::class)

    override val layoutRes: Int
        get() = R.layout.fragment_shop

    override fun observerViewModel() {
        with(viewModel) {
            goodsAdapter.shortClick.observe(this@ShopFragment, Observer {
                DataObject.setGoods(goodsList[it])
                startActivity(GoodsActivity::class.java)
            })
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllGoods()
    }
}