package com.mine.demomvvm.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.mine.demomvvm.cloud.RetrofitClient
import com.mine.demomvvm.cloud.contract.CloudLoginManager
import com.mine.demomvvm.cloud.requestmodel.LoginRequest
import com.mine.demomvvm.cloud.responsemodel.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository {

    companion object {
        private var repository: LoginRepository? = null
        @Synchronized
        fun getInstance(): LoginRepository {
            if (repository == null) {
                repository = LoginRepository()
            }
            return repository as LoginRepository
        }
    }


     fun doLogin(loginModel:LoginRequest): MutableLiveData<List<LoginResponse>> {
        val data:MutableLiveData<List<LoginResponse>> = MutableLiveData()
        val loginManager = RetrofitClient.getClient().create(CloudLoginManager::class.java)
        val call = loginManager.getLoginData()
        call.enqueue(object:Callback<List<LoginResponse>>{
            override fun onFailure(call: Call<List<LoginResponse>>, t: Throwable) {
                data.value = null
            }
            override fun onResponse(call: Call<List<LoginResponse>>, response: Response<List<LoginResponse>>) {
                data.value = response.body()
            }
        })
        return data
    }




}