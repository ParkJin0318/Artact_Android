package com.hackathon.artact.view.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import com.hackathon.artact.R
import com.hackathon.artact.base.BaseActivity
import com.hackathon.artact.databinding.ActivityRegisterBinding
import com.hackathon.artact.viewmodel.RegisterViewModel
import com.hackathon.artact.widget.extension.shortToast
import com.hackathon.artact.widget.extension.startActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

class RegisterActivity : BaseActivity<ActivityRegisterBinding, RegisterViewModel>() {

    override val viewModel: RegisterViewModel
        get() = getViewModel(RegisterViewModel::class)

    override val layoutRes: Int
        get() = R.layout.activity_register

    private lateinit var array: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSpinnerItems()
    }

    override fun observerViewModel() {
        with(viewModel) {
            onRegisterEvent.observe(this@RegisterActivity, Observer {
                register()
            })
            onBackEvent.observe(this@RegisterActivity, Observer {
                onBackPressed()
            })
            onEmptyEvent.observe(this@RegisterActivity, Observer {
                shortToast(R.string.error_empty)
            })
            onNotMatchEvent.observe(this@RegisterActivity, Observer {
                shortToast(R.string.error_not_match)
            })
            onSuccessEvent.observe(this@RegisterActivity, Observer {
                startActivity(MainActivity::class.java)
            })
            onErrorEvent.observe(this@RegisterActivity, Observer {
                shortToast(it.message)
            })
        }
    }

    private fun setSpinnerItems() {
        array = resources.getStringArray(R.array.age_array)
        val ageAdapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, array)
        binding.ageSpinner.adapter = ageAdapter
        addPlaceSpinnerListener()
    }

    private fun addPlaceSpinnerListener() {
        binding.ageSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val age = array[position]
                viewModel.age.value = age.substring(0, age.length - 1)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) { }
        }
    }
}