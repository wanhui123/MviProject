package com.wh.mviproject.ui.main

import com.wh.mviproject.base.BaseViewModel
import com.wh.mviproject.base.IUiIntent
import com.wh.mviproject.model.repository.HomeRepository

/**
 * Created by WanHui on 2023/1/31
 */
class MainViewModel(private val homeRepo: HomeRepository) : BaseViewModel<MainState, MainIntent>() {
    override fun initUiState(): MainState {
        return MainState(BannerUiState.INIT, DetailUiState.INIT)
    }

    override fun handleIntent(intent: IUiIntent) {
        when (intent) {
            MainIntent.GetBanner -> {
                requestDataWithFlow(showLoading = true,
                    request = { homeRepo.requestWanData() },
                    successCallback = { data ->
                        //获取到数据 改变UI状态
                        sendUiState {
                            copy(
                                bannerUiState = BannerUiState.SUCCESS(
                                    data
                                )
                            )
                        }
                    },
                    failCallback = {})
            }
            is MainIntent.GetDetail -> {
                requestDataWithFlow(showLoading = false,
                    request = { homeRepo.requestRankData(intent.page) },
                    successCallback = { data ->
                        sendUiState {
                            copy(
                                detailUiState = DetailUiState.SUCCESS(
                                    data
                                )
                            )
                        }
                    })
            }
        }
    }
}