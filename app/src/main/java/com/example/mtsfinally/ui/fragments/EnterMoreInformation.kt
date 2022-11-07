package com.example.mtsfinally.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mtsfinally.MainActivity
import com.example.mtsfinally.R
import com.example.mtsfinally.RegisterLogIn
import com.example.mtsfinally.utilits.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_enter_more_information.*
import kotlinx.android.synthetic.main.fragment_enter_number_and_code.*
import kotlinx.android.synthetic.main.fragment_welcome.*

class EnterMoreInformation : BaseFragment(R.layout.fragment_enter_more_information) {
    lateinit var status: String
    lateinit var name: String
    lateinit var surname: String

    override fun onStart() {
        super.onStart()
        bt_dancer.setImageResource(R.drawable.anon)
        bt_choreographer.setImageResource(R.drawable.anon)
        bt_parent.setImageResource(R.drawable.anon)

        bt_regMoreinf.setOnClickListener {
            addUser(status)
        }

        bt_dancer.setOnClickListener{
            status = "1"
            initEdMenu(status)
        }

        bt_parent.setOnClickListener{
            status = "2"
            initEdMenu(status)
        }

        bt_choreographer.setOnClickListener{
            status = "3"
            initEdMenu(status)
        }

    }

    private fun initEdMenu(status: String){
        horizontal_scroll_view.visibility = View.GONE
        ed_code.visibility = View.VISIBLE
        ed_name.visibility = View.VISIBLE
        ed_surname.visibility = View.VISIBLE

        when(status){
            "1" -> {

                ed_code.hint = "Код пригласившего друга."
            }
            "2" -> {
                ed_code.hint = "Код хореографа"
            }
            "3" -> {
                ed_code.hint = "Код ребёнка"
            }
        }
    }

    private fun addUser(status: String){
        val uid = AUTH.currentUser?.uid.toString()
        val phone = AUTH.currentUser?.phoneNumber.toString()

        name = ed_name.text.toString()
        surname = ed_name.text.toString()

        val dateMap = mutableMapOf<String, Any>()
        dateMap[USER_ID] = uid
        dateMap[USER_PHONE] = phone
        dateMap[USER_STATUS] = status
        dateMap[USER_SURNAME] = surname
        dateMap[USER_NAME] = name
        when(status){
            "1" -> {
                dateMap[USER_COINS] = 0
                dateMap[USER_COINS] = 0
            }
            "3" -> {
                dateMap[USER_COINS] = 0
                dateMap[USER_COINS] = 0
            }
        }

        REF_DATABASE_ROOT.child(NODE_USERS).child(uid).updateChildren(dateMap).addOnCompleteListener{
            if(it.isSuccessful){
                (activity as RegisterLogIn).replaceActivity(MainActivity())
            }else{
                showToast("Произошла ошибка при работе с базой данных.")
            }
        }
        }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EnterMoreInformation()
    }
}