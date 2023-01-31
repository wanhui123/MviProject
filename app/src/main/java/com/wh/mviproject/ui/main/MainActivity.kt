package com.wh.mviproject.ui.main

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.wh.mviproject.R
import com.wh.mviproject.base.BaseActivity
import com.wh.mviproject.databinding.ActivityMainBinding
import com.wh.mviproject.ui.main.fragment.*

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun initViews() {
        Log.d("", "initViews")
        binding.navView.setOnItemSelectedListener {
            Log.d("", "initViews: $it")
            when (it.itemId) {
                R.id.navigation_home -> switchFragment(0)
                R.id.navigation_blog -> switchFragment(1)
                R.id.navigation_search -> switchFragment(2)
                R.id.navigation_project_type -> switchFragment(3)
                R.id.navigation_me -> switchFragment(4)
            }
            true
        }

        initViewPager()
    }

    private fun switchFragment(position: Int) {
        Log.d("", "switchFragment")
        binding.mainViewPager.setCurrentItem(position, true)
    }

    private fun initViewPager() {
        binding.mainViewPager.isUserInputEnabled = false
        binding.mainViewPager.offscreenPageLimit = 2
        binding.mainViewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = 5

            override fun createFragment(position: Int): Fragment = when (position) {
                0 -> HomeFragment()
                1 -> BlogFragment()
                2 -> SearchFragment()
                3 -> ProjectFragment()
                4 -> MeFragment()
                else -> HomeFragment()
            }

        }
    }


    override fun initEvents() {
        super.initEvents()
    }
}