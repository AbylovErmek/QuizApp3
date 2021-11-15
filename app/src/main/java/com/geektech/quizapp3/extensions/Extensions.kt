package com.geektech.quizapp3.extensions

import android.content.Context
import android.view.View
import android.widget.Toast

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

var View.visible: Boolean
    get() = visibility == View.GONE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }
