package com.mine.demomvvm.cloud.responsemodel

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("userId")val userIdentification:String,
    @SerializedName("id") val id:String,
    @SerializedName("title") val title:String,
    @SerializedName("body") val body:String
)