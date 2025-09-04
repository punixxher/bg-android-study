package com.bg.study

import android.app.Application
import com.bg.study.flow.di.ServiceLocator

class App: Application(){
    override fun onCreate() {
        super.onCreate()
        ServiceLocator.init(this)
    }
}