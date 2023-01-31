package com.wh.mviproject.base

import com.google.gson.annotations.SerializedName

/**
 * Created by WanHui on 2023/1/31
 */
class BaseData<T> {
    @SerializedName("errorCode")
    var code = -1

    @SerializedName("errorMsg")
    var msg: String? = null
    var data: T? = null
    var state: ReqState = ReqState.Error
}

enum class ReqState {
    Success, Error
}