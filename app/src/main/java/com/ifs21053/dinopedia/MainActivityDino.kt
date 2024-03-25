//Nama      : Grase Thessalonika Panjaitan
//NIM       : 11S21053
//Materi    : Perbaikan Ujian Tengah Semester PAM

package com.ifs21053.dinopedia

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21053.dinopedia.databinding.ActivityMainDinoBinding

class MainActivityDino : AppCompatActivity() {

    private lateinit var binding: ActivityMainDinoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout using ViewBinding
        binding = ActivityMainDinoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up RecyclerView
        binding.rvDino.setHasFixedSize(true)

        // Set up list of Dino and show them in RecyclerView
        val dataDino = getListDino()
        showRecyclerList(dataDino)

        // Set up click listener for "About" TextView
        val btnUser = findViewById<TextView>(R.id.menu_about)
        btnUser.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
    }

    @SuppressLint("Recycle")
    private fun getListDino(): ArrayList<Dino> {

        val family = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(
                EXTRA_FAMILI,
                Family::class.java
            )
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_FAMILI)
        }

        val dataNamaDino = resources.getStringArray(R.array.dino_nama)
        val dataIconDino = resources.obtainTypedArray(R.array.dino_foto)
        val dataDeskripsiDino = resources.getStringArray(R.array.dino_deskripsi)
        val dataKarakteristikDino = resources.getStringArray(R.array.dino_karakteristik)
        val dataKelompokDino = resources.getStringArray(R.array.dino_kelompok)
        val dataHabitatDino = resources.getStringArray(R.array.dino_habitat)
        val dataMakananDino = resources.getStringArray(R.array.dino_makanan)
        val dataPanjangDino = resources.getStringArray(R.array.dino_panjang)
        val dataTinggiDino = resources.getStringArray(R.array.dino_tinggi)
        val dataBobotDino = resources.getStringArray(R.array.dino_bobot)
        val dataKelemahanDino = resources.getStringArray(R.array.dino_kelemahan)

        val startIndex = family?.mulai
        val endIndex = family?.selesai

        val dinoList = ArrayList<Dino>()
        for (i in startIndex!!..endIndex!!) {
            val dino = Dino(
                dataNamaDino[i],
                dataIconDino.getResourceId(i, -1),
                dataDeskripsiDino[i],
                dataKarakteristikDino[i],
                dataKelompokDino[i],
                dataHabitatDino[i],
                dataMakananDino[i],
                dataPanjangDino[i],
                dataTinggiDino[i],
                dataBobotDino[i],
                dataKelemahanDino[i]
            )
            dinoList.add(dino)
        }
        // Release the TypedArray
        dataIconDino.recycle()
        return dinoList
    }




    private fun showRecyclerList(dataDino: ArrayList<Dino>) {
        val layoutManager = if (resources.configuration.orientation ==
            Configuration.ORIENTATION_LANDSCAPE) {
            GridLayoutManager(this, 2)
        } else {
            LinearLayoutManager(this)
        }

        binding.rvDino.layoutManager = layoutManager
        val listDinoAdapter = ListDinoAdapter(dataDino)
        binding.rvDino.adapter = listDinoAdapter
        listDinoAdapter.setOnItemClickCallback(object : ListDinoAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Dino) {
                showSelectedDino(data)
            }
        })
    }

    private fun showSelectedDino(dino: Dino) {
        val intentWithData = Intent(this@MainActivityDino, DetailActivityDino::class.java)
        intentWithData.putExtra(DetailActivityDino.EXTRA_DINO, dino)
        startActivity(intentWithData)
    }
    companion object{
        const val EXTRA_FAMILI = "extra_famili"
    }
}
