package org.d3if4033.mobpro2.submission1.core.domain.usecase


import kotlinx.coroutines.flow.Flow
import org.d3if4033.mobpro2.submission1.core.data.Resource
import org.d3if4033.mobpro2.submission1.core.domain.model.Banyuwangi

interface BanyuwangiUseCase {
    fun getAllBanyuwangi(): Flow<Resource<List<Banyuwangi>>>
    fun getFavoriteBanyuwangi(): Flow<List<Banyuwangi>>
    fun setFavoriteBanyuwangi(banyuwangi: Banyuwangi, state: Boolean)
}