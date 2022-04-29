package com.example.project_test_mvvm_retrofit_login.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.project_test_mvvm_retrofit_login.R
import com.example.project_test_mvvm_retrofit_login.data.remote.UserRequest
import com.example.project_test_mvvm_retrofit_login.data.remote.UserResponse
import com.example.project_test_mvvm_retrofit_login.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
        btnSignIn.setOnClickListener {
            userLogin()
        }

    }

    private fun userLogin() {
        val displayNamee: String = edtName.text.toString().trim()
        var passwordd: String = edtPassword.text.toString().trim()

        if (displayNamee.isEmpty() || passwordd.isEmpty()) {
            Toast.makeText(this, "Invalid information", Toast.LENGTH_SHORT).show()
        } else {
            val request = UserRequest()
            request.apply {
                displayName = displayNamee
                password = passwordd
            }
//            request.displayName = displayName
//            request.password = password
            viewModel.userLogin(request)
        }

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
//        viewModel.getLoginRx().observe(this) { userResponse ->
//            userResponse?.let {
//                val displayName: String = it.data?.userData?.displayName ?: ""
//                val id: String = (it.data?.userData?.id ?: 0).toString()
//                val intent = Intent(this, HomeActivity::class.java)
//                intent.putExtra("id", id)
//                intent.putExtra("displayName", displayName)
//                startActivity(intent)
//            }
        //}
        viewModel.getLoginObserver().observe(this, Observer<UserResponse?> { userResponse ->
            userResponse?.let {
                val displayName: String = it.data?.userData?.displayName ?: ""
                val id: String = (it.data?.userData?.id ?: 0).toString()
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("id", id)
                intent.putExtra("displayName", displayName)
                startActivity(intent)

            }
        })
    }
}