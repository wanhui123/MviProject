package com.wh.mviproject.model.repository

import com.wh.mviproject.base.BaseData
import com.wh.mviproject.base.BaseRepository
import com.wh.mviproject.model.bean.Article
import com.wh.mviproject.model.bean.Banner
import com.wh.mviproject.model.http.WanRetrofitClient

/**
 * Created by WanHui on 2023/1/31
 */
class HomeRepository : BaseRepository() {
    private val service = WanRetrofitClient.service

    suspend fun requestWanData(): BaseData<List<Banner>> {
        return executeRequest { service.getBanner() }
    }

    suspend fun requestRankData(page: Int): BaseData<Article> {
        return executeRequest { service.getArticle(page) }
    }
}