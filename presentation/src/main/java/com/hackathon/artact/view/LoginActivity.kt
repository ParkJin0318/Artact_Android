package com.hackathon.artact.view

import com.hackathon.artact.R
import com.hackathon.artact.base.BaseActivity
import com.hackathon.artact.databinding.ActivityLoginBinding
import com.hackathon.artact.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {

    override val viewModel: LoginViewModel
        get() = getViewModel(LoginViewModel::class)

    override val layoutRes: Int
        get() = R.layout.activity_login

    override fun observerViewModel() { }
}