package com.example.project_test_mvvm_retrofit_login.data.network

import com.example.project_test_mvvm_retrofit_login.data.remote.UserRequest
import com.example.project_test_mvvm_retrofit_login.data.remote.UserResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserApi {
    @FormUrlEncoded
    @POST("login")
    fun login(
//        @Body userRequest: UserRequest
        @Field("display_name") displayName: String?,
        @Field("password") password: String?
    ): Observable<UserResponse>
}