package com.example.mtsfinally.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mtsfinally.R
import com.example.mtsfinally.databinding.FragmentProfileChoreoBinding
import com.example.mtsfinally.utilits.UsersAdapter
import com.example.mtsfinally.utilits.UsersRecycleView
import com.example.mtsfinally.utilits.showToast
import kotlinx.android.synthetic.main.fragment_profile_choreo.*


class ProfileChoreo : Fragment(R.layout.fragment_profile_choreo) {
    private var adapter = UsersAdapter()
    private val usersIdList = listOf("Вася", "Петя", "Санёк", "Петя", "Эдуард")


    override fun onStart() {
        super.onStart()
        init()
    }

    private fun init(){
        val index = usersIdList.size
        rc_view.layoutManager = LinearLayoutManager(context)
        rc_view.adapter = adapter

        for(i in 0 until index) {
            val user = UsersRecycleView(usersIdList[i])
            Log.d("logi", "$user")
            adapter.add_users(user)


        }
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileChoreo().apply {
                arguments = Bundle() }
    }
}