package com.example.project_test_mvvm_retrofit_login.data.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserRequest{

    @SerializedName("display_name")
    @Expose
    var displayName: String? = null

    @SerializedName("password")
    @Expose
    var password: String? = null

    override fun toString(): String {
        return "User(displayName=$displayName, password=$password)"
    }
}





