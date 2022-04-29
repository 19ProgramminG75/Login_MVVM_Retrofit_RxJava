package com.example.project_test_mvvm_retrofit_login.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project_test_mvvm_retrofit_login.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        tvId.text ="id: ${intent.getStringExtra("id")}"
        tvName.text ="display_name: " + intent.getStringExtra("displayName")
    }
}