package com.ifs21053.dinopedia;

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
        family = intent.getParcelableExtra(EXTRA_FAMILY)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if (family != null) {
            supportActionBar?.title = "Jenis Olahraga ${family!!.name}"
            loadData(family!!)
        } else {
            finish()
        }

        val btnLogin: Button = findViewById(R.id.btnKembali)

        btnLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }

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
