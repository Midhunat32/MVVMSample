package com.mine.demomvvm.view.fragment.login


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mine.demomvvm.R
import com.mine.demomvvm.callback.ClickCallBack
import com.mine.demomvvm.cloud.requestmodel.LoginRequest
import com.mine.demomvvm.cloud.responsemodel.LoginResponse
import com.mine.demomvvm.databinding.FragmentLoginBinding
import com.mine.demomvvm.view.utility.DisplayInfo
import com.mine.demomvvm.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*


/**
 * A simple [Fragment] subclass.
 *
 */
class LoginFragment : Fragment(){

    private var loginViewModel:LoginViewModel?=null
    private lateinit var binding:FragmentLoginBinding
    private var userName:String?=null
    private var password:String?=null

    companion object Factory{
        fun newInstance(): LoginFragment = LoginFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.loginCallback = callback
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
    }


    var callback = object :ClickCallBack{
        override fun onClick() {
            if(isValid()){
                DisplayInfo.showProgressBar(activity!!)
                val loginRequest  = LoginRequest(userName!!,password!!)
                observeLoginViewModel(loginViewModel,loginRequest)
            }
        }

    }

    fun observeLoginViewModel(loginViewModel: LoginViewModel?, loginRequest: LoginRequest) {
        loginViewModel?.getLoginObservable(loginRequest)?.observe(this,Observer<List<LoginResponse>>(){
            DisplayInfo.dismissProgressBar(activity!!)
            val response :List<LoginResponse> = it!!
            DisplayInfo.showToast(activity!!,response[0].title)
        })
    }


    fun isValid():Boolean{
        userName = etUserName.text.toString().trim()
        password = etPassword.text.toString().trim()
        if (TextUtils.isEmpty(userName)){
            etUserName.setError("Invalid Field")
            return false
        }
        if (TextUtils.isEmpty(password)){
            etPassword.setError("Imvalid Filed")
            return false
        }

        return true
    }

}
