package com.wh.mviproject.eventbus

/**
 * Created by WanHui on 2023/1/31
 */
sealed class Event {
    data class ShowInit(val msg: String) : Event()
}