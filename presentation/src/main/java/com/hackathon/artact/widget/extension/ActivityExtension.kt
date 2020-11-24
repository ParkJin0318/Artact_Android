package com.hackathon.artact.widget.extension

import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable

fun AppCompatActivity.shortToast(message: String?) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.shortToast(message: Int) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.startActivity(activity: Class<*>) {
    startActivity(Intent(applicationContext, activity).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP))
}

fun AppCompatActivity.startActivityWithValue(activity: Class<*>, name: String, value: Serializable) {
    startActivity(Intent(applicationContext, activity).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP).putExtra(name, value))
}

fun AppCompatActivity.startActivityWithFinish(activity: Class<*>) {
    startActivity(Intent(applicationContext, activity).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
    this.finish()
}