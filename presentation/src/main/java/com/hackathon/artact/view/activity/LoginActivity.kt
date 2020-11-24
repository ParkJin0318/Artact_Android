package com.hackathon.artact.view.activity

import androidx.lifecycle.Observer
import com.hackathon.artact.R
import com.hackathon.artact.base.BaseActivity
import com.hackathon.artact.databinding.ActivityLoginBinding
import com.hackathon.artact.viewmodel.LoginViewModel
import com.hackathon.artact.widget.extension.shortToast
import com.hackathon.artact.widget.extension.startActivity
import com.hackathon.artact.widget.extension.startActivityWithFinish
import org.koin.androidx.viewmodel.ext.android.getViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {

    override val viewModel: LoginViewModel
        get() = getViewModel(LoginViewModel::class)

    override val layoutRes: Int
        get() = R.layout.activity_login

    override fun observerViewModel() {
        with(viewModel) {
            onLoginEvent.observe(this@LoginActivity, Observer {
                login()
            })
            onBackEvent.observe(this@LoginActivity, Observer {
                onBackPressed()
            })
            onEmptyEvent.observe(this@LoginActivity, Observer {
                shortToast(R.string.error_empty)
            })
            onSuccessEvent.observe(this@LoginActivity, Observer {
                startActivityWithFinish(MainActivity::class.java)
            })
            onErrorEvent.observe(this@LoginActivity, Observer {
                shortToast(it.message)
            })
        }
    }
}