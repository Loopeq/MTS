package com.example.mtsfinally.utilits

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mtsfinally.R
import com.example.mtsfinally.databinding.UsersItemBinding
import kotlinx.android.synthetic.main.users_item.view.*

class UsersAdapter: RecyclerView.Adapter<UsersAdapter.UsersHolder>() {
    val userList = ArrayList<UsersRecycleView>()

    class UsersHolder(item: View) : RecyclerView.ViewHolder(item){
        val binding = UsersItemBinding.bind(item)
        @SuppressLint("SetTextI18n")
        fun bind(user: UsersRecycleView) = with(binding){
            btUser.text = user.name



        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.users_item, parent, false)
        return UsersHolder(view)
    }

    override fun onBindViewHolder(holder: UsersHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun add_users(users: UsersRecycleView){
        userList.add(users)
        notifyDataSetChanged()
    }

}