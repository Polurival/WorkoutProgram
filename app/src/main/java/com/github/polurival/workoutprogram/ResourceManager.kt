package com.github.polurival.workoutprogram

import android.content.Context

/**
 * @author Polurival on 08.04.2018.
 */
class ResourceManager(val context: Context) {
    fun getString(stringId: Int): String {
        return context.getString(stringId)
    }
}