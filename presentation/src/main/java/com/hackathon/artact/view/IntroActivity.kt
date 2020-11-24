package com.hackathon.artact.view

import androidx.lifecycle.Observer
import com.hackathon.artact.R
import com.hackathon.artact.base.BaseActivity
import com.hackathon.artact.databinding.ActivityIntroBinding
import com.hackathon.artact.viewmodel.IntroViewModel
import com.hackathon.artact.widget.extension.startActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

class IntroActivity : BaseActivity<ActivityIntroBinding, IntroViewModel>() {

    override val viewModel: IntroViewModel
        get() = getViewModel(IntroViewModel::class)

    override val layoutRes: Int
        get() = R.layout.activity_intro

    override fun observerViewModel() {
        with(viewModel) {
            onLoginEvent.observe(this@IntroActivity, Observer {
                startActivity(LoginActivity::class.java)
            })
            onRegisterEvent.observe(this@IntroActivity, Observer {
                startActivity(RegisterActivity::class.java)
            })
        }
    }
}