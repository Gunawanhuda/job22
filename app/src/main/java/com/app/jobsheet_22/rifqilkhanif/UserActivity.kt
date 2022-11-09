package com.app.jobsheet_22.rifqilkhanif

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.app.jobsheet_22.rifqikhanif.Session

class UserActivity : AppCompatActivity() {

    private lateinit var logoutBtn: Button
    private lateinit var nama_lengkap: TextView
    private lateinit var sessionManager: Session

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        sessionManager = Session(this)

        logoutBtn = findViewById(R.id.btnLogout)
        nama_lengkap = findViewById(R.id.textNama)

        if (!sessionManager.isLoggeIn()) {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            nama_lengkap.text = sessionManager.getUser()
        }
        logoutBtn.setOnClickListener{
            val session = sessionManager.logout()
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}



