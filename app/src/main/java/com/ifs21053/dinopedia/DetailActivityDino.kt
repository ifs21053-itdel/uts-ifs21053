//Nama      : Grase Thessalonika Panjaitan
//NIM       : 11S21053
//Materi    : Perbaikan Ujian Tengah Semester PAM

package com.ifs21053.dinopedia;

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ifs21053.dinopedia.databinding.ActivityDetailDinoBinding

class DetailActivityDino : AppCompatActivity() {

    private lateinit var binding: ActivityDetailDinoBinding
    private var dino: Dino? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDinoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dino = intent.getParcelableExtra(EXTRA_DINO)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if (dino != null) {
            supportActionBar?.title = "Jenis Dinosaurus ${dino!!.name}"
            loadData(dino!!)
        } else {
            finish()
        }

        val btnLogin: Button = findViewById(R.id.btnKembaliDino)

        btnLogin.setOnClickListener {
            val intent = Intent(this, ListDinoAdapter::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }

        val btnKembalikeDino: Button = findViewById(R.id.buttonDinoAnak)

        btnKembalikeDino.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }

    }

    private fun loadData(dino: Dino) {
        binding.ivDetailIcon.setImageResource(dino.icon)
        binding.tvDetailName.text = dino.name
        binding.tvDetailDeskripsi.text = dino.deskripsi
        binding.tvKarakteristik.text = dino.karakteristik
        binding.tvKelompok.text = dino.kelompok
        binding.tvHabitat.text = dino.habitat
        binding.tvMakanan.text = dino.makanan
        binding.tvPanjang.text = dino.panjang
        binding.tvTinggi.text = dino.tinggi
        binding.tvBobot.text = dino.bobot
        binding.tvKelemahan.text = dino.kelemahan
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val EXTRA_DINO = "extra_dino"
    }
}
