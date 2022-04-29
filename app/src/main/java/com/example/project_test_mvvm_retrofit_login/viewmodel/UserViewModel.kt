package com.example.project_test_mvvm_retrofit_login.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.project_test_mvvm_retrofit_login.data.network.RetroInstance
import com.example.project_test_mvvm_retrofit_login.data.network.UserApi
import com.example.project_test_mvvm_retrofit_login.data.remote.UserRequest
import com.example.project_test_mvvm_retrofit_login.data.remote.UserResponse
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel: ViewModel() {
    var loginLiveData: MutableLiveData<UserResponse?> = MutableLiveData()
    val TAG = "test"
    
//    fun userLogin(userRequest: UserRequest){
//        val retroService = RetroInstance.getRetroInstance().create(UserApi::class.java)
//        val call = retroService.login(userRequest.displayName, userRequest.password)
//        call.enqueue(object : Callback<UserResponse>{
//            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
//                if (response.isSuccessful){
//                    loginLiveData.postValue(response.body())
//                }else{
//                    loginLiveData.postValue(null)
//                }
//            }
//            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
//                loginLiveData.postValue(null)
//
//            }
//
//        })
//    }

    fun getLoginObserver(): MutableLiveData<UserResponse?> {
        return loginLiveData
    }

    @SuppressLint("CheckResult")
    fun userLogin(userRequest: UserRequest){
        val retroService = RetroInstance.getRetroInstance().create(UserApi::class.java)
        retroService.login(userRequest.displayName, userRequest.password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getLoginRx())

    }

    private fun getLoginRx(): Observer<UserResponse> {
        return object : Observer<UserResponse> {
            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, "onSubscribe: ")
            }

            override fun onNext(t: UserResponse) {
                loginLiveData.postValue(t)
            }

            override fun onError(e: Throwable) {
                loginLiveData.postValue(null)
            }

            override fun onComplete() {
                Log.d(TAG, "onComplete: ")
            }


        }
    }


}