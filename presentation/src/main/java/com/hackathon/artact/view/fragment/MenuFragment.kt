package com.hackathon.artact.view.fragment

import com.hackathon.artact.R
import com.hackathon.artact.base.BaseFragment
import com.hackathon.artact.databinding.FragmentMenuBinding
import com.hackathon.artact.viewmodel.MenuViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MenuFragment : BaseFragment<FragmentMenuBinding, MenuViewModel>() {

    override val viewModel: MenuViewModel
        get() = getViewModel(MenuViewModel::class)

    override val layoutRes: Int
        get() = R.layout.fragment_menu

    override fun observerViewModel() { }
}