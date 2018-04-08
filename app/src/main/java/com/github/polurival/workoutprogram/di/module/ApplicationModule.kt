package com.github.polurival.workoutprogram.di.module

import android.app.Application
import com.github.polurival.workoutprogram.ResourceManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Polurival on 08.04.2018.
 */
@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideResourceManager(): ResourceManager = ResourceManager(application.applicationContext)
}