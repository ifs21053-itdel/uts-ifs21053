//Nama      : Grase Thessalonika Panjaitan
//NIM       : 11S21053
//Materi    : Perbaikan Ujian Tengah Semester PAM

package com.ifs21053.dinopedia

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21053.dinopedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout using ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up RecyclerView
        binding.rvFamily.setHasFixedSize(false)

        // Set up list of Family and show them in RecyclerView
        val dataFamily = getListFamily()
        showRecyclerList(dataFamily)

        // Set up click listener for "About" TextView
        val btnUser = findViewById<TextView>(R.id.menu_about)
        btnUser.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
    }

    @SuppressLint("Recycle")
    private fun getListFamily(): ArrayList<Family> {
        val dataNama = resources.getStringArray(R.array.family_nama)
        val dataIcon = resources.obtainTypedArray(R.array.family_icon)
        val dataDeskripsi = resources.getStringArray(R.array.family_deskripsi)
        val dataPriode = resources.getStringArray(R.array.family_periode)
        val dataFisik = resources.getStringArray(R.array.family_fisik)
        val dataHabitat = resources.getStringArray(R.array.family_habitat)
        val dataLingkungan = resources.getStringArray(R.array.family_lingkungan)
        val dataPrilaku = resources.getStringArray(R.array.family_prilaku)
        val mulai = resources.getStringArray(R.array.start)
        val selesai = resources.getStringArray(R.array.end)

        val listFamily = ArrayList<Family>()
        for (i in dataNama.indices) {
            val family = Family(
                dataNama[i],
                dataIcon.getResourceId(i, -1),
                dataDeskripsi[i],
                dataPriode[i],
                dataFisik[i],
                dataHabitat[i],
                dataLingkungan[i],
                dataPrilaku[i],
                mulai[i].toInt(),
                selesai[i].toInt(),
            )
            listFamily.add(family)
        }
        return listFamily
    }

    private fun showRecyclerList(dataFamily: ArrayList<Family>) {
        val layoutManager = if (resources.configuration.orientation ==
            Configuration.ORIENTATION_LANDSCAPE) {
            GridLayoutManager(this, 2)
        } else {
            LinearLayoutManager(this)
        }

        binding.rvFamily.layoutManager = layoutManager
        val listFamilyAdapter = ListFamilyAdapter(dataFamily)
        binding.rvFamily.adapter = listFamilyAdapter
        listFamilyAdapter.setOnItemClickCallback(object : ListFamilyAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Family) {
                showSelectedFamily(data)
            }
        })
    }

    private fun showSelectedFamily(family: Family) {
        val intentWithData = Intent(this@MainActivity, DetailActivity::class.java)
        intentWithData.putExtra(DetailActivity.EXTRA_FAMILY, family)
        startActivity(intentWithData)
    }
}
