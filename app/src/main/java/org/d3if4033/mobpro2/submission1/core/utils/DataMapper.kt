package org.d3if4033.mobpro2.submission1.core.utils

import org.d3if4033.mobpro2.submission1.core.data.source.local.entity.BanyuwangiEntity
import org.d3if4033.mobpro2.submission1.core.data.source.remote.response.BanyuwangiResponse
import org.d3if4033.mobpro2.submission1.core.domain.model.Banyuwangi

object DataMapper {
    fun mapResponsesToEntities(input: List<BanyuwangiResponse>): List<BanyuwangiEntity> {
        val banyuwangiList = ArrayList<BanyuwangiEntity>()
        input.map {
            val banyuwangi = BanyuwangiEntity(
                id = it.id,
                deskrpisi = it.deskripsi,
                nama = it.nama,
                like = it.like,
                gambar = it.image,
                isFavorite = false
            )
            banyuwangiList.add(banyuwangi)
        }
        return banyuwangiList
    }

    fun mapEntitiesToDomain(input: List<BanyuwangiEntity>): List<Banyuwangi> =
        input.map {
            Banyuwangi(
                id = it.id,
                deskripsi = it.deskrpisi,
                nama = it.nama,
                like = it.like,
                gambar = it.gambar,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Banyuwangi) = BanyuwangiEntity(
        id = input.id,
        deskrpisi = input.deskripsi,
        nama = input.nama,
        like = input.like,
        gambar = input.gambar,
        isFavorite = input.isFavorite
    )
}