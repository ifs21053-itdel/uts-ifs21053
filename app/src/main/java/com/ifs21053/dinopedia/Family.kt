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
) : Parcelable

