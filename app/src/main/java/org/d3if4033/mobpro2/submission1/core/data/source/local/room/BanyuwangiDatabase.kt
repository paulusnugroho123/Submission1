package org.d3if4033.mobpro2.submission1.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import org.d3if4033.mobpro2.submission1.core.data.source.local.entity.BanyuwangiEntity

@Database(entities = [BanyuwangiEntity::class], version = 1, exportSchema = false)
abstract class BanyuwangiDatabase : RoomDatabase() {

    abstract fun banyuwangiDao(): BanyuwangiDao
}