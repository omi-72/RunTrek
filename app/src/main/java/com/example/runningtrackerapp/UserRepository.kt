package com.example.runningtrackerapp

import android.util.Log
import javax.inject.Inject

const val TAG = "MYCODE"

class UserRepository {
    fun saveUser(email: String, password:String){
        Log.d(TAG, "User Saved inDB")
    }
}