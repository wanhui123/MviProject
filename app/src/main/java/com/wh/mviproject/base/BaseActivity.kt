package com.wh.mviproject.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * Created by WanHui on 2023/1/31
 */
abstract class BaseActivity<T : ViewBinding>: AppCompatActivity(){
    private lateinit var _binding: T

    protected val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getViewBinding()

        initViews()
        initEvents()
    }

    protected abstract fun getViewBinding(): T

    open fun initViews() {}
    open fun initEvents() {}

    /**
     * @param str 弹出的文字
     */
    fun toast(str: String?) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }
}