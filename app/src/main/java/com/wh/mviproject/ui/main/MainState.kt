package com.wh.mviproject.ui.main

import com.wh.mviproject.base.IUiState
import com.wh.mviproject.model.bean.Article
import com.wh.mviproject.model.bean.Banner

/**
 * Created by WanHui on 2023/1/31
 */
data class MainState(val bannerUiState: BannerUiState, val detailUiState: DetailUiState) : IUiState

sealed class BannerUiState {
    object INIT : BannerUiState()
    data class SUCCESS(val models: List<Banner>) : BannerUiState()
}

sealed class DetailUiState {
    object INIT : DetailUiState()
    data class SUCCESS(val articles: Article) : DetailUiState()
}