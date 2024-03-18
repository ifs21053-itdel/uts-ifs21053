// ChildItemAdapter.kt
package com.ifs21053.dinopedia

import android.content.Context
import android.content.res.TypedArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChildItemAdapter(private val context: Context, private val childItemList: List<ChildItem>) :
    RecyclerView.Adapter<ChildItemAdapter.ChildViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.child_item, parent, false)
        return ChildViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        val childItem = childItemList[position]
        val resourceId = getResourceIdFromStringArray(childItem.childItemTitle)
        holder.imgChildItem.setImageResource(resourceId)
        holder.childItemTitle.text = childItem.childItemTitle
    }

    override fun getItemCount(): Int {
        return childItemList.size
    }

    inner class ChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgChildItem: ImageView = itemView.findViewById(R.id.img_child_item)
        val childItemTitle: TextView = itemView.findViewById(R.id.child_item_title)
    }

    private fun getResourceIdFromStringArray(childItemTitle: String): Int {
        val imagesArray: TypedArray = context.resources.obtainTypedArray(R.array.child_item_images)
        val parentItemTitles = context.resources.getStringArray(R.array.parent_item_titles)
        val index = parentItemTitles.indexOf(childItemTitle)
        val resourceId = if (index != -1) {
            imagesArray.getResourceId(index, R.drawable.icon)
        } else {
            R.drawable.icon
        }
        imagesArray.recycle()
        return resourceId
    }
}
