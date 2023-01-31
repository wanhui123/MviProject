package com.wh.mviproject.model.http.api

import com.wh.mviproject.base.BaseData
import com.wh.mviproject.model.bean.Article
import com.wh.mviproject.model.bean.Banner
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by WanHui on 2023/1/31
 */
interface WanApi {
    @GET("banner/json")
    suspend fun getBanner(): BaseData<List<Banner>>

    //页码从0开始
    @GET("article/list/{page}/json")
    suspend fun getArticle(@Path("page") page: Int): BaseData<Article>
}