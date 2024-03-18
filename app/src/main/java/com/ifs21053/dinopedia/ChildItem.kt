package com.ifs21053.dinopedia

class ChildItem(val childItemTitle: String) {

    @JvmName("getCustomChildItemTitle")
    fun getChildItemTitle(): String {
        return childItemTitle
    }
}
