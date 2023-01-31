package com.wh.mviproject.base

import androidx.annotation.Keep

/**
 * Created by WanHui on 2023/1/31
 */
@Keep
interface IUiState

@Keep
interface IUiIntent //event

sealed class LoadUiIntent {
    data class Loading(var isShow: Boolean) : LoadUiIntent()
    object ShowMainView : LoadUiIntent()
    data class Error(val msg: String) : LoadUiIntent()
}