package org.d3if4033.mobpro2.submission1.core.data


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.d3if4033.mobpro2.submission1.core.data.source.local.LocalDataSource
import org.d3if4033.mobpro2.submission1.core.data.source.remote.RemoteDataSource
import org.d3if4033.mobpro2.submission1.core.data.source.remote.network.ApiResponse
import org.d3if4033.mobpro2.submission1.core.data.source.remote.response.BanyuwangiResponse
import org.d3if4033.mobpro2.submission1.core.domain.model.Banyuwangi
import org.d3if4033.mobpro2.submission1.core.domain.repository.IBanyuwangiRepository
import org.d3if4033.mobpro2.submission1.core.utils.AppExecutors
import org.d3if4033.mobpro2.submission1.core.utils.DataMapper

class BanyuwangiRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IBanyuwangiRepository {

    override fun getAllBanyuwangi(): Flow<Resource<List<Banyuwangi>>> =
        object : NetworkBoundResource<List<Banyuwangi>, List<BanyuwangiResponse>>() {
            override fun loadFromDB(): Flow<List<Banyuwangi>> {
                return localDataSource.getAllBanyuwangi().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Banyuwangi>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<BanyuwangiResponse>>> =
                remoteDataSource.getAllTourism()

            override suspend fun saveCallResult(data: List<BanyuwangiResponse>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertBanyuwangi(tourismList)
            }
        }.asFlow()

    override fun getFavoriteBanyuwangi(): Flow<List<Banyuwangi>> {
        return localDataSource.getFavoriteBanyuwangi().map {
           DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteBanyuwangi(banyuwangi: Banyuwangi, state: Boolean) {
        val banyuwangiEntity = DataMapper.mapDomainToEntity(banyuwangi)
        appExecutors.diskIO().execute { localDataSource.setFavoriteBanyuwangi(banyuwangiEntity, state) }
    }
}

