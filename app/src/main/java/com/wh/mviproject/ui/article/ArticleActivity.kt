package com.wh.mviproject.ui.article

import com.wh.mviproject.base.BaseActivity
import com.wh.mviproject.databinding.ActivityArticleBinding
import com.wh.mviproject.eventbus.Event
import com.wh.mviproject.eventbus.FlowEventBus

/**
 * Created by WanHui on 2023/1/31
 */
class ArticleActivity : BaseActivity<ActivityArticleBinding>() {
    override fun getViewBinding(): ActivityArticleBinding  = ActivityArticleBinding.inflate(layoutInflater)

    override fun initViews() {
        super.initViews()
        binding.reset.setOnClickListener {
            FlowEventBus.post(Event.ShowInit("article init"))
            finish()
        }
    }
}