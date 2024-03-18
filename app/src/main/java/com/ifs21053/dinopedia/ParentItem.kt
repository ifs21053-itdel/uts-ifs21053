package com.ifs21053.dinopedia

class ParentItem(var parentItemTitle: String, var childItemList: List<ChildItem>) {

    // Constructor
    constructor(parentItemTitle: String) : this(parentItemTitle, emptyList())

    // Metode untuk menambahkan child item ke dalam list
    fun addChildItem(childItem: ChildItem) {
        childItemList += childItem
    }

    // Metode untuk menghapus child item dari list
    fun removeChildItem(childItem: ChildItem) {
        childItemList -= childItem
    }
}
