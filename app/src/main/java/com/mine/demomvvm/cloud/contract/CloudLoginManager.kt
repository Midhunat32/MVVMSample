package com.mine.demomvvm.cloud.contract

import com.mine.demomvvm.cloud.requestmodel.LoginRequest
import com.mine.demomvvm.cloud.responsemodel.LoginResponse
import retrofit2.Call
import retrofit2.http.GET

interface CloudLoginManager {
    @GET("posts")
    fun getLoginData():Call<List<LoginResponse>>
}