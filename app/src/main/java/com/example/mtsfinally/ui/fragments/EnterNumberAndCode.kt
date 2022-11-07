package com.example.mtsfinally.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mtsfinally.MainActivity
import com.example.mtsfinally.R
import com.example.mtsfinally.RegisterLogIn
import com.example.mtsfinally.utilits.AUTH
import com.example.mtsfinally.utilits.replaceActivity
import com.example.mtsfinally.utilits.replaceFragment
import com.example.mtsfinally.utilits.showToast
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_enter_number_and_code.*
import kotlinx.android.synthetic.main.fragment_welcome.view.*
import java.util.concurrent.TimeUnit


class EnterNumberAndCode : BaseFragment(R.layout.fragment_enter_number_and_code) {
    private lateinit var phoneNumber: String
    private lateinit var mCallBack: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    private lateinit var authId: String
    private lateinit var code: String

    override fun onStart() {
        super.onStart()
        bt_getCode.setOnClickListener { sendCode() }
        bt_next.setOnClickListener { enterCode() }
        create_callback_obj()
    }

    private fun sendCode(){
        if(ed_phone.text.toString().isEmpty()){
            showToast("Введите номер телефона")
        } else { authUser() }
    }

    private fun enterCode() {
        code = ed_enterCode.text.toString()
        if(code.isEmpty() && code.length == 6) {
            showToast("Введите код")
        } else { logInUser(code) }

    }

    private fun logInUser(code: String){
        if (code.length == 6) {
            val credential = PhoneAuthProvider.getCredential(authId, code)
            AUTH.signInWithCredential(credential).addOnCompleteListener {
                if (it.isSuccessful) {
                    showToast("Добро пожаловать")
                    (context as RegisterLogIn).replaceFragment(EnterMoreInformation())
                } else {
                    showToast(it.exception?.message.toString())
                }
            }
        }
    }

    private fun authUser(){
        phoneNumber = ed_phone.text.toString()
        PhoneAuthProvider.verifyPhoneNumber(
            PhoneAuthOptions
                .newBuilder(FirebaseAuth.getInstance())
                .setActivity(activity as RegisterLogIn)
                .setPhoneNumber(phoneNumber)
                .setTimeout(60L, TimeUnit.SECONDS)
                .setCallbacks(mCallBack)
                .build()
        )
    }

    private fun create_callback_obj(){
        mCallBack = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks(){

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                AUTH.signInWithCredential(credential).addOnCompleteListener{
                    if(it.isSuccessful){
                        showToast("Добро пожаловать")
                        (activity as RegisterLogIn).replaceActivity(MainActivity())
                    }else{
                        showToast(it.exception?.message.toString())
                    }
                }
            }
            override fun onVerificationFailed(p0: FirebaseException) {
                showToast(p0.message.toString())
            }

            override fun onCodeSent(id: String, token: PhoneAuthProvider.ForceResendingToken) {
                authId = id
                ed_enterCode.visibility = View.VISIBLE
                bt_next.visibility = View.VISIBLE
            }

        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EnterNumberAndCode()
    }
}
