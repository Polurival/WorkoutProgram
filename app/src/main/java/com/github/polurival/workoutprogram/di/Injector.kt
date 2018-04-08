package com.github.polurival.workoutprogram.di

import com.github.polurival.workoutprogram.MainApplication

/**
 * @author Polurival on 08.04.2018.
 */
class Injector private constructor() {
    companion object {
        fun appComponent(): AppComponent = MainApplication.INSTANCE.component
    }
}