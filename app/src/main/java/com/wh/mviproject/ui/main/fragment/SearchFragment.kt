package com.wh.mviproject.ui.main.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.wh.mviproject.base.BaseFragment
import com.wh.mviproject.databinding.FragmentSearchBinding

/**
 * Created by WanHui on 2023/1/31
 */
class SearchFragment: BaseFragment<FragmentSearchBinding>() {
    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?) = FragmentSearchBinding.inflate(layoutInflater)

    override fun initViews() {
    }

    override fun initDatas() {
    }
}