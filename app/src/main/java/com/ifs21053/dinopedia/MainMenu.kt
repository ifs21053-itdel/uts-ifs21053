package com.ifs21053.dinopedia

import android.content.Context
import android.content.Intent

class MainMenu {
    companion object {
        fun navigateToAboutActivity(context: Context) {
            val intent = Intent(context, AboutActivity::class.java)
            context.startActivity(intent)
        }
    }
}
