package com.hackathon.artact.widget.extension

import android.content.Intent
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.io.Serializable

fun Fragment.shortToast(message: String?) {
    Toast.makeText(context!!.applicationContext, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.shortToast(message: Int) {
    Toast.makeText(context!!.applicationContext, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.startActivity(activity: Class<*>) {
    startActivity(Intent(context!!.applicationContext, activity).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP))
}

fun Fragment.startActivityWithFinish(activity: Class<*>) {
    startActivity(Intent(context!!.applicationContext, activity).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
    requireActivity().finish()
}

fun Fragment.startActivityWithValue(activity: Class<*>, name: String, value: Serializable) {
    startActivity(Intent(context!!.applicationContext, activity).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP).putExtra(name, value))
}