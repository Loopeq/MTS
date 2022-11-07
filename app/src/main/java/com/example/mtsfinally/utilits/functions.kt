package com.example.mtsfinally.utilits

import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.fragment.app.Fragment
import com.example.mtsfinally.R
import com.example.mtsfinally.RegisterLogIn
import com.example.mtsfinally.ui.fragments.ProfileFragment

fun Fragment.showToast(message: String){
    Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.replaceActivity(activity: AppCompatActivity){
    intent = Intent(this, activity::class.java)
    startActivity(intent)
    this.finish()
}

fun AppCompatActivity.replaceFragment(fragment: Fragment){
    supportFragmentManager.beginTransaction()
        .replace(R.id.dataContent, fragment).commit()
}