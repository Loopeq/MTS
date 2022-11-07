package com.example.mtsfinally

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mtsfinally.databinding.ActivityMainBinding
import com.example.mtsfinally.databinding.ActivityRegisterLogInBinding
import com.example.mtsfinally.ui.fragments.WelcomeFragment
import com.example.mtsfinally.utilits.initFirebase

class RegisterLogIn : AppCompatActivity() {
    lateinit var mBinding: ActivityRegisterLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisterLogInBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initFirebase()
    }

    override fun onStart() {
        super.onStart()
        supportFragmentManager.beginTransaction()
            .add(R.id.dataContent, WelcomeFragment())
            .commit()
    }
}