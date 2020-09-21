package org.d3if4033.mobpro2.submission1.core.data.source.local


import kotlinx.coroutines.flow.Flow
import org.d3if4033.mobpro2.submission1.core.data.source.local.entity.BanyuwangiEntity
import org.d3if4033.mobpro2.submission1.core.data.source.local.room.BanyuwangiDao

class LocalDataSource(private val banyuwangiDao: BanyuwangiDao) {


    fun getAllBanyuwangi(): Flow<List<BanyuwangiEntity>> = banyuwangiDao.getAllBanyuwangi()

    fun getFavoriteBanyuwangi(): Flow<List<BanyuwangiEntity>> = banyuwangiDao.getFavoriteBanyuwangi()

    suspend fun insertBanyuwangi(banyuwangiList: List<BanyuwangiEntity>) = banyuwangiDao.insertBanyuwangi(banyuwangiList)

    fun setFavoriteBanyuwangi(banyuwangi: BanyuwangiEntity, newState: Boolean) {
        banyuwangi.isFavorite = newState
        banyuwangiDao.updateFavoriteBanyuwangi(banyuwangi)
    }
}