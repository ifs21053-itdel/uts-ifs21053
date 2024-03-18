package com.ifs21053.dinopedia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val parentRecyclerViewItem: RecyclerView = findViewById(R.id.parent_recyclerview)

        // Initialise the Linear layout manager
        val layoutManager = LinearLayoutManager(this)

        // Pass the context and the list of parent items to the ParentItemAdapter constructor
        val parentItemAdapter = ParentItemAdapter(this, getListParentItems())

        // Set the layout manager and adapter for items
        // of the parent recyclerview
        parentRecyclerViewItem.adapter = parentItemAdapter
        parentRecyclerViewItem.layoutManager = layoutManager
    }

    private fun getListParentItems(): List<ParentItem> {
        val parentItemTitles = resources.getStringArray(R.array.parent_item_titles)

        val listParentItems = ArrayList<ParentItem>()
        for ((index, parentItemTitle) in parentItemTitles.withIndex()) {
            val parentItem = ParentItem(parentItemTitle, getChildItemList(index))
            listParentItems.add(parentItem)
        }
        return listParentItems
    }

    // Method to pass the arguments for the elements
    // of child RecyclerView
    private fun getChildItemList(parentItemIndex: Int): List<ChildItem> {
        val childItemList = ArrayList<ChildItem>()

        // Load child item array based on parent item index
        val childItemArray = when (parentItemIndex) {
            0 -> R.array.child_item_theropoda
            1 -> R.array.child_item_sauropoda
            2 -> R.array.child_item_ornithopoda
            3 -> R.array.child_item_ankylosauria
            4 -> R.array.child_item_ceratopsia
            5 -> R.array.child_item_pachycephalosauria
            6 -> R.array.child_item_hypsilophodontidae
            7 -> R.array.child_item_therizinosauridae

            else -> return childItemList // Return empty list if no matching index
        }

        // Load child items from the corresponding array
        val childItemTitles = resources.getStringArray(childItemArray)
        for (childItemTitle in childItemTitles) {
            childItemList.add(ChildItem(childItemTitle))
        }

        return childItemList
    }
}
