package com.wh.mviproject.model.bean

/**
 * Created by WanHui on 2023/1/31
 */
data class Article(
    var curPage: Int,
    val datas: List<ArticleItem>
)

data class ArticleItem(
    val title: String,
    val link: String,
    val userId: Int,
    val niceDate: String
)