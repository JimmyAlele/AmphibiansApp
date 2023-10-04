package com.alele.amphibians

import android.app.Application
import com.alele.amphibians.data.AppContainer
import com.alele.amphibians.data.DefaultAppContainer

class AmphibiansApplication: Application() {
    /** AppContainer containing instance used by the rest of classes to obtain dependencies */
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}