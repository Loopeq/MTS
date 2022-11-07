package com.example.mtsfinally.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mtsfinally.R
import com.example.mtsfinally.databinding.FragmentWelcomeBinding
import kotlinx.android.synthetic.main.fragment_welcome.*
import kotlinx.android.synthetic.main.fragment_welcome.view.*

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    override fun onStart() {
        bt_logIn.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.dataContent, EnterNumberAndCode())
                .commit()
        }
        super.onStart()

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WelcomeFragment()
    }

}
