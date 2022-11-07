package com.example.mtsfinally

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.mtsfinally.databinding.ActivityMainBinding
import com.example.mtsfinally.ui.fragments.*
import com.example.mtsfinally.utilits.AUTH
import com.example.mtsfinally.utilits.replaceActivity
import com.example.mtsfinally.utilits.replaceFragment
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
    override fun onStart() {
        super.onStart()
        initFunc()
    }

    private fun initFunc(){
        AUTH = FirebaseAuth.getInstance()
        if(AUTH.currentUser!=null) {
            getToolbar()
            getProfileChoreoFragment()
        }else{
            replaceActivity(RegisterLogIn())
        }

    }

    private fun getToolbar(){

    }



    // Получить фрагменты
//--------------------------------------------------------------------------------------------------
    private fun getNewsFragment(){
        replaceFragment(NewsFragment())


    }

    private fun getSheduleFragment(){
        replaceFragment(SheduleFragment())

    }

    private fun getRatingFragment(){

    }

    private fun getShopFragment(){

    }

    private fun getProfileFragment(){
        replaceFragment(ProfileFragment())

    }

    private fun getProfileChoreoFragment(){
        replaceFragment(ProfileChoreo())
    }
//--------------------------------------------------------------------------------------------------
}