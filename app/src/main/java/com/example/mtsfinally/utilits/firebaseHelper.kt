package com.example.mtsfinally.utilits

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

lateinit var AUTH: FirebaseAuth
lateinit var REF_DATABASE_ROOT: DatabaseReference


const val NODE_USERS = "users"

const val NODE_BOSS = "boss"

const val USER_ID = "id"
const val USER_NAME = "name"
const val USER_SURNAME  = "surname"
const val USER_LIKES = "likes"
const val USER_PHONE = "phone"
const val USER_COINS = "coins"
const val USER_STATUS = "status"


fun initFirebase(){
    AUTH = FirebaseAuth.getInstance()
    REF_DATABASE_ROOT = FirebaseDatabase.getInstance().reference
}