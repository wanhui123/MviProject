package com.wh.mviproject.ui.main.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.wh.mviproject.base.BaseFragment
import com.wh.mviproject.databinding.FragmentProjectBinding

/**
 * Created by WanHui on 2023/1/31
 */
class ProjectFragment: BaseFragment<FragmentProjectBinding>() {
    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?) = FragmentProjectBinding.inflate(layoutInflater)

    override fun initViews() {
    }

    override fun initDatas() {
    }
}