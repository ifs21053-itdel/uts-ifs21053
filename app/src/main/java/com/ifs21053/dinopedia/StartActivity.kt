//Nama      : Grase Thessalonika Panjaitan
//NIM       : 11S21053
//Materi    : Perbaikan Ujian Tengah Semester PAM

package com.ifs21053.dinopedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import com.ifs21053.dinopedia.MainActivity
import com.ifs21053.dinopedia.R

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val btnLogin: Button = findViewById(R.id.buttonMenu)

        btnLogin.setOnClickListener {
//            intent sebagai komunikasi antara komponen untuk menghubungkan komunikasi antar activity
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK) //stack dibersihkan dan mainActivity akan dimulai sebagai aktivitas baru
            startActivity(intent)
            finish() //menutup aktivitas login
        }
    }
}
