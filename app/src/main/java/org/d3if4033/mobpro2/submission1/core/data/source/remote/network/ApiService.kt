package org.d3if4033.mobpro2.submission1.core.data.source.remote.network

import org.d3if4033.mobpro2.submission1.core.data.source.remote.response.ListBanyuwangiResponse
import retrofit2.http.GET

interface ApiService {
    @GET("submission-c1bd0-export.json?alt=media&token=d5e3db53-6cc0-4ebb-b5f5-dd31147cf0c3")
    suspend fun getList(): ListBanyuwangiResponse
}
