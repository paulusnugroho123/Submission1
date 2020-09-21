package org.d3if4033.mobpro2.submission1.core.data.source.local.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import org.d3if4033.mobpro2.submission1.core.data.source.local.entity.BanyuwangiEntity

@Dao
interface BanyuwangiDao {

    @Query("SELECT * FROM banyuwangi")
    fun getAllBanyuwangi(): Flow<List<BanyuwangiEntity>>

    @Query("SELECT * FROM banyuwangi where isFavorite = 1")
    fun getFavoriteBanyuwangi(): Flow<List<BanyuwangiEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBanyuwangi(banyuwangi: List<BanyuwangiEntity>)

    @Update
    fun updateFavoriteBanyuwangi(banyuwangi: BanyuwangiEntity)
}
