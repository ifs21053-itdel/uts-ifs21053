//Nama      : Grase Thessalonika Panjaitan
//NIM       : 11S21053
//Materi    : Perbaikan Ujian Tengah Semester PAM

package com.ifs21053.dinopedia;

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Family(
    var name: String,
    var icon: Int,
    var deskripsi: String,
    var periode: String,
    var fisik: String,
    var habitat: String,
    var lingkungan: String,
    var prilaku: String,
    var mulai : Int,
    var selesai : Int,
) : Parcelable

