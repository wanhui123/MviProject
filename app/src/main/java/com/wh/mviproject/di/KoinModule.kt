package com.wh.mviproject.di

import com.wh.mviproject.model.repository.HomeRepository
import com.wh.mviproject.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by WanHui on 2023/1/31
 */
val repoModule = module {
    single { HomeRepository() }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}

val appModule = listOf(viewModelModule, repoModule)