package com.mine.demomvvm.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.mine.demomvvm.cloud.requestmodel.LoginRequest
import com.mine.demomvvm.cloud.responsemodel.LoginResponse
import com.mine.demomvvm.repository.LoginRepository

class LoginViewModel(application: Application) : AndroidViewModel(application) {

  fun getLoginObservable(request: LoginRequest):LiveData<List<LoginResponse>>{
      return LoginRepository.getInstance().doLogin(request)
  }

}