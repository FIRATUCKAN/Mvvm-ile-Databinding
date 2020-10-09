package com.example.mvvm_databinding

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel  : ViewModel() {

    var username: ObservableField<String>? = null
    var password: ObservableField<String>? = null
    var message = MutableLiveData<String>().apply { value = null }
    init {
        username = ObservableField("")
        password = ObservableField("")
    }

    fun login() {

        val usernameTxt = username?.get()
        val passwordTxt = password?.get()

        if (usernameTxt.isNullOrEmpty() || passwordTxt.isNullOrEmpty()) {
            return
        }

        if(usernameTxt == "username" && passwordTxt == "password"){
            message.value="Giriş Başarılı"
        }
        else{
            message.value="Giriş Başarısız"
        }

    }
}
