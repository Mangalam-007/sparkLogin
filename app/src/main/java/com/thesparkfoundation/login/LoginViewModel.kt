package com.thesparkfoundation.login

import android.content.Context
import android.preference.PreferenceManager
import androidx.lifecycle.map

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class LoginViewModel:ViewModel() {

    enum class AuthenticationState{
        AUTHENTICATED, UNAUTHENTICATED
    }

    val authenticationState = FirebaseUserLiveData().map { user ->
        if(user !=null){
            AuthenticationState.AUTHENTICATED
        }
            else
        {
            AuthenticationState.UNAUTHENTICATED
        }
    }
}