package com.wh.mviproject

import android.app.Application
import com.wh.mviproject.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

/**
 * Created by WanHui on 2023/1/31
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            //开始启动koin
            androidLogger()
            androidContext(this@App)//这边传Application对象,这样你注入的类中,需要app对象的时候,可以直接使用
            modules(appModule)//这里面传各种被注入的模块对象,支持多模块注入
        }
    }
}