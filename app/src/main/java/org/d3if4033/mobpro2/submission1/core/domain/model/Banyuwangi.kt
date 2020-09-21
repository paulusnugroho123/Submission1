package org.d3if4033.mobpro2.submission1.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Banyuwangi(
    val id: String,
    val nama: String,
    val deskripsi: String,
    val like: Int,
    val gambar: String,
    val isFavorite: Boolean
) : Parcelable