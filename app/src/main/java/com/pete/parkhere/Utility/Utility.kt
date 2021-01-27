package com.pete.parkhere.Utility

import android.content.Context
import android.widget.Toast

fun Context.SToast(text: String) {
    Toast.makeText(this,text,Toast.LENGTH_SHORT)
            .show()
}