//Nama      : Grase Thessalonika Panjaitan
//NIM       : 11S21053
//Materi    : Perbaikan Ujian Tengah Semester PAM

package com.ifs21053.dinopedia

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ifs21053.dinopedia.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private var family: Family? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mendapatkan data Family dari intent
        family = intent.getParcelableExtra(EXTRA_FAMILY)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if (family != null) {
            // Mengatur judul ActionBar
            supportActionBar?.title = "Jenis Family ${family!!.name}"
            // Memuat data family ke tampilan
            loadData(family!!)
        } else {
            // Jika tidak ada data family, tutup activity
            finish()
        }

        // Mendapatkan referensi button dari layout
        val btnLogin: Button = findViewById(R.id.btnKembali)
        // Menambahkan listener untuk button
        btnLogin.setOnClickListener {
            // Kembali ke MainActivity
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }

        // Mendapatkan referensi button dino dari layout
        val btnDino: Button = findViewById(R.id.buttonDino1)
        // Menambahkan listener untuk button dino
        btnDino.setOnClickListener {
            // Kembali ke MainActivityDino
            val intent = Intent(this, MainActivityDino::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }

        // Menambahkan listener untuk button Dino untuk menampilkan MainActivityDino dengan data Family
        binding.buttonDino1.setOnClickListener {
            val intentWithData = Intent(this@DetailActivity, MainActivityDino::class.java)
            intentWithData.putExtra(MainActivityDino.EXTRA_FAMILI, family!!)
            startActivity(intentWithData)
        }
    }

    // Memuat data Family ke tampilan
    private fun loadData(family: Family) {
        binding.ivDetailIcon.setImageResource(family.icon)
        binding.tvDetailName.text = family.name
        binding.tvDetailDeskripsi.text = family.deskripsi
        binding.tvPeriode.text = family.periode
        binding.tvFisik.text = family.fisik
        binding.tvHabitat.text = family.habitat
        binding.tvLingkungan.text = family.lingkungan
        binding.tvPrilaku.text = family.prilaku
    }

    // Mendukung tombol kembali di ActionBar
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
        const val EXTRA_FAMILY = "extra_family"
    }
}
