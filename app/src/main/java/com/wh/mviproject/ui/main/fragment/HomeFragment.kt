package com.wh.mviproject.ui.main.fragment

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.wh.mviproject.base.BaseFragment
import com.wh.mviproject.base.LoadUiIntent
import com.wh.mviproject.databinding.FragmentHomeBinding
import com.wh.mviproject.eventbus.Event
import com.wh.mviproject.eventbus.FlowEventBus
import com.wh.mviproject.ui.main.BannerUiState
import com.wh.mviproject.ui.main.DetailUiState
import com.wh.mviproject.ui.main.MainIntent
import com.wh.mviproject.ui.main.MainViewModel
import com.wh.mviproject.ui.main.adapter.ArticleAdapter
import com.wh.mviproject.ui.main.adapter.BannerAdapter
import kotlinx.coroutines.flow.map
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by WanHui on 2023/1/31
 */
class HomeFragment: BaseFragment<FragmentHomeBinding>() {
    companion object {
        private const val TAG = "HomeFragment"
    }

    private lateinit var bannerAdapter: BannerAdapter
    private lateinit var articleAdapter: ArticleAdapter
    private val mViewModel by viewModel<MainViewModel>()

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?) = FragmentHomeBinding.inflate(layoutInflater)

    override fun initViews() {
        Log.d(TAG,"initViews")
        bannerAdapter = BannerAdapter()
        binding.viewPager.adapter = bannerAdapter

        articleAdapter = ArticleAdapter()
        binding.recyclerView.adapter = articleAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                context, DividerItemDecoration.VERTICAL
            )
        )
    }

    override fun initDatas() {
        binding.button.setOnClickListener {
            //获取Banner 意图
            mViewModel.sendUiIntent(MainIntent.GetBanner)
            //获取详情 意图
            mViewModel.sendUiIntent(MainIntent.GetDetail(0))
        }

        lifecycleScope.launchWhenStarted {
            //loading 显示
            mViewModel.loadUiIntentFlow.collect { state ->
                Log.d(TAG, "loadUiStateFlow: $state")
                when (state) {
                    is LoadUiIntent.Error -> {
                        Log.d(TAG, state.msg)
                    }
                    is LoadUiIntent.ShowMainView -> {
                        binding.viewPager.isVisible = true
                        binding.recyclerView.isVisible = true
                        binding.button.isVisible = false
                    }
                    is LoadUiIntent.Loading -> {

                        Log.d(TAG, "show loading  ${state.isShow}")
                    }
                }
            }
        }
        lifecycleScope.launchWhenStarted {
            //banner数据
            mViewModel.uiStateFlow.map { it.bannerUiState }
                .collect { bannerUiState ->
                    Log.d(TAG, "bannerUiState: $bannerUiState")
                    when (bannerUiState) {
                        is BannerUiState.INIT -> {}
                        is BannerUiState.SUCCESS -> {
                            binding.viewPager.isVisible = true
                            binding.button.isVisible = false
                            val imgs = mutableListOf<String>()
                            for (model in bannerUiState.models) {
                                imgs.add(model.imagePath)
                            }
                            bannerAdapter.setList(imgs)
                        }
                    }
                }
        }
        lifecycleScope.launchWhenStarted {
            //detail数据
            mViewModel.uiStateFlow.map { it.detailUiState }
                .collect { detailUiState ->
                    Log.d(TAG, "detailUiState: $detailUiState")
                    when (detailUiState) {
                        is DetailUiState.INIT -> {}
                        is DetailUiState.SUCCESS -> {
                            binding.recyclerView.isVisible = true
                            val list = detailUiState.articles.datas
                            articleAdapter.setList(list)
                        }
                    }

                }
        }

        FlowEventBus.observe<Event.ShowInit>(this, Lifecycle.State.STARTED) {
            it.msg
            binding.viewPager.isVisible = false
            binding.recyclerView.isVisible = false
            binding.button.isVisible = true
        }
    }
}