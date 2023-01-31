package com.wh.mviproject.ui.article

import com.wh.mviproject.base.BaseActivity
import com.wh.mviproject.databinding.ActivityArticleBinding

/**
 * Created by WanHui on 2023/1/31
 */
class ArticleActivity : BaseActivity<ActivityArticleBinding>() {
    override fun getViewBinding(): ActivityArticleBinding  = ActivityArticleBinding.inflate(layoutInflater)

    override fun initViews() {
        super.initViews()
    }
}