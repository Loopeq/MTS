package com.example.mtsfinally.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mtsfinally.R


class NewsFragment : BaseFragment(R.layout.fragment_news) {

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewsFragment()
            }
    }
