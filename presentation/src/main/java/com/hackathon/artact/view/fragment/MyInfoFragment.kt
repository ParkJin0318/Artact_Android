package com.hackathon.artact.view.fragment

import com.hackathon.artact.R
import com.hackathon.artact.base.BaseFragment
import com.hackathon.artact.databinding.FragmentMyInfoBinding
import com.hackathon.artact.viewmodel.MyInfoViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MyInfoFragment: BaseFragment<FragmentMyInfoBinding, MyInfoViewModel>() {

    override val viewModel: MyInfoViewModel
        get() = getViewModel(MyInfoViewModel::class)

    override val layoutRes: Int
        get() = R.layout.fragment_my_info

    override fun observerViewModel() { }
}