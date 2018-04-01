package com.github.polurival.workoutprogram.ui.recyclerview


import android.support.annotation.IdRes
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.*

/**
 * https://www.raywenderlich.com/172711/intermediate-recyclerview
 *
 * @author Polurival on 01.04.2018.
 */
class DefaultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val viewMap: MutableMap<Int, View> = HashMap()

    init {
        findViewItems(itemView)
    }

    fun setText(@IdRes id: Int, text: String) {
        val view = (viewMap[id]
                ?: throw IllegalArgumentException("View for $id not found")) as? TextView
                ?: throw IllegalArgumentException("View for $id is not a TextView")
        view.text = text
    }

    private fun findViewItems(itemView: View) {
        addToMap(itemView)
        if (itemView is ViewGroup) {
            val childCount = itemView.childCount
            (0 until childCount)
                    .map { itemView.getChildAt(it) }
                    .forEach { findViewItems(it) }
        }
    }

    private fun addToMap(itemView: View) {
        if (itemView.id == View.NO_ID) {
            itemView.id = View.generateViewId()
        }
        viewMap[itemView.id] = itemView
    }
}