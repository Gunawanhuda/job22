package com.app.jobsheet_22.rifqikhanif

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Session(context: Context) {
    private val USERNAME_KEY = "key_username"
    private val NAMA_LENGKAP_KEY = "key_nama_lengkap"

    private var preferences: SharedPreferences = context.getSharedPreferences("Login App", Context.MODE_PRIVATE)

    fun getUser(): String? {
        return preferences.getString(NAMA_LENGKAP_KEY, null)
    }

    fun setSession(username: String?, nama_lengkap: String?) {
        preferences.edit().putString(USERNAME_KEY, username)
            .apply()

        preferences.edit().putString(NAMA_LENGKAP_KEY, nama_lengkap)
            .apply()
    }
    fun isLoggeIn(): Boolean {
        val username = preferences.getString(USERNAME_KEY, null)
        return username != null
    }
    fun validate(username: String, password: String): Boolean {
        val namaLengkap = "M.Huda Gunawan"
        if (username == "Huda" && password == "huda123") {
            setSession(username, namaLengkap)
            return true
        }
        if (username == "Radiva" && password == "Radiva123") {
            setSession(username, namaLengkap)
            return true
        }
        if (username == "3014" && password == "3014") {
            setSession(username, namaLengkap)
            return true
        }
        return false
    }
    fun logout() {
        preferences.edit().remove(USERNAME_KEY)
            .remove(NAMA_LENGKAP_KEY)
            .apply()
    }
}