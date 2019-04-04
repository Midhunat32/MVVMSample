package com.mine.demomvvm.view.utility

import android.app.Activity
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ProgressBar
import android.widget.Toast
import com.mine.demomvvm.R

class DisplayInfo {

    companion object {
        public fun showToast(context: Context,message:String){
            Toast.makeText(context,message,Toast.LENGTH_LONG).show()
        }

        fun showProgressBar(actvity: Activity){
            actvity.findViewById<ProgressBar>(R.id.progressBar).visibility = View.VISIBLE
        }

        fun dismissProgressBar(actvity: Activity){
            actvity.findViewById<ProgressBar>(R.id.progressBar).visibility = View.GONE
        }

        fun hideKeyBoard(context: Activity){
            val im = context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            im.apply {
                if (im.isAcceptingText){
                    im.hideSoftInputFromWindow(context.currentFocus.windowToken,0)
                }
            }
        }
    }



}