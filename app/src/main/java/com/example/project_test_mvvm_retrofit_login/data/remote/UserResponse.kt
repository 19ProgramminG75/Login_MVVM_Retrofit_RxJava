package com.example.project_test_mvvm_retrofit_login.data.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserResponse {
    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("data")
    @Expose
    var data: Data? = null

    class Data {
        @SerializedName("token")
        @Expose
        var token: String? = null

        @SerializedName("user")
        @Expose
        var userData: User? = null

        override fun toString(): String {
            return "Data(token=$token, userData=$userData)"
        }

    }

    class User {
        @SerializedName("id")
        @Expose
        var id: Int? = null

        @SerializedName("display_name")
        @Expose
        var displayName: String? = null

        override fun toString(): String {
            return "User(id=$id, displayName=$displayName)"
        }


    }

    override fun toString(): String {
        return "UserResponse(status=$status, message=$message, data=$data)"
    }


}