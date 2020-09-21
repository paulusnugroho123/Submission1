package org.d3if4033.mobpro2.submission1.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class BanyuwangiResponse(
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("nama")
    val nama: String,

    @field:SerializedName("deskripsi")
    val deskripsi: String,

    @field:SerializedName("like")
    val like: Int,

    @field:SerializedName("gambar")
    val image: String
)

