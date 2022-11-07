package com.example.mtsfinally.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mtsfinally.R
import com.example.mtsfinally.databinding.FragmentSheduleBinding

class SheduleFragment : BaseFragment(R.layout.fragment_shedule) {

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SheduleFragment()
    }
}