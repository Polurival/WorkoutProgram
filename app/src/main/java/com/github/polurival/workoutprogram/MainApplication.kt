package com.github.polurival.workoutprogram

import android.app.Application
import com.github.polurival.workoutprogram.di.AppComponent
import com.github.polurival.workoutprogram.di.DaggerAppComponent
import com.github.polurival.workoutprogram.di.module.ApplicationModule

/**
 * @author Polurival on 08.04.2018.
 */
class MainApplication : Application() {

    lateinit var component: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        component = createComponent()
    }

    private fun createComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    companion object {
        lateinit var INSTANCE: MainApplication
            private set
    }
}