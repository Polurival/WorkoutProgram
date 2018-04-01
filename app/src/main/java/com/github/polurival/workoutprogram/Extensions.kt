package com.github.polurival.workoutprogram

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

/**
 * @author Polurival on 31.03.2018.
 */

/**
 * https://medium.com/thoughts-overflow/how-to-add-a-fragment-in-kotlin-way-73203c5a450b
 */
inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction()
            .func()
            .commit()
}

/**
 * https://medium.com/thoughts-overflow/how-to-add-a-fragment-in-kotlin-way-73203c5a450b
 */
fun FragmentActivity.addFragment(@IdRes frameId: Int, fragment: Fragment) {
    supportFragmentManager.inTransaction { add(frameId, fragment) }
}

/**
 * https://medium.com/thoughts-overflow/how-to-add-a-fragment-in-kotlin-way-73203c5a450b
 */
fun FragmentActivity.replaceFragment(@IdRes frameId: Int, fragment: Fragment) {
    supportFragmentManager.inTransaction {
        addToBackStack(null)
        replace(frameId, fragment)
    }
}

