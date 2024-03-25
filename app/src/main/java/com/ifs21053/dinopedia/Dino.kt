//Nama      : Grase Thessalonika Panjaitan
//NIM       : 11S21053
//Materi    : Perbaikan Ujian Tengah Semester PAM

package com.ifs21053.dinopedia;

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dino(
    var name: String,
    var icon: Int,
    var deskripsi: String,
    var karakteristik: String,
    var kelompok: String,
    var habitat: String,
    var makanan: String,
    var panjang: String,
    var tinggi: String,
    var bobot: String,
    var kelemahan: String,
) : Parcelable

