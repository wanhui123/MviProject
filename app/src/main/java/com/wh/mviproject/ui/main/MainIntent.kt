package com.wh.mviproject.ui.main

import com.wh.mviproject.base.IUiIntent

/**
 * Created by WanHui on 2023/1/31
 */
sealed class MainIntent : IUiIntent {
    object GetBanner : MainIntent()
    data class GetDetail(val page: Int) : MainIntent()
}