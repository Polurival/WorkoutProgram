package com.github.polurival.workoutprogram.di

import com.github.polurival.workoutprogram.ResourceManager
import com.github.polurival.workoutprogram.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

/**
 * @author Polurival on 08.04.2018.
 */
@Singleton
@Component(modules = [(ApplicationModule::class)])
interface AppComponent {
    fun getResourceManager(): ResourceManager
}