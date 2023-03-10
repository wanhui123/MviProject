package com.wh.mviproject.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * Created by WanHui on 2023/1/31
 */
abstract class BaseFragment<T : ViewBinding> : Fragment() {
    private var _binding: T? = null
    protected val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = getViewBinding(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
        initDatas()
        super.onViewCreated(view, savedInstanceState)
    }

    protected abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): T

    abstract fun initViews()
    abstract fun initDatas()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}