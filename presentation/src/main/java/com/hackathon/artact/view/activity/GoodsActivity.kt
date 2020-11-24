package com.hackathon.artact.view.activity

import androidx.lifecycle.Observer
import com.hackathon.artact.R
import com.hackathon.artact.base.BaseActivity
import com.hackathon.artact.databinding.ActivityGoodsBinding
import com.hackathon.artact.viewmodel.GoodsViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class GoodsActivity : BaseActivity<ActivityGoodsBinding, GoodsViewModel>() {

    override val viewModel: GoodsViewModel
        get() = getViewModel(GoodsViewModel::class)

    override val layoutRes: Int
        get() = R.layout.activity_goods

    override fun observerViewModel() {
        with(viewModel) {
            onBackEvent.observe(this@GoodsActivity, Observer {
                onBackPressed()
            })
        }
    }
}