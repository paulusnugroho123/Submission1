package org.d3if4033.mobpro2.submission1.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListBanyuwangiResponse(

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("places")
    val places: List<BanyuwangiResponse>
)