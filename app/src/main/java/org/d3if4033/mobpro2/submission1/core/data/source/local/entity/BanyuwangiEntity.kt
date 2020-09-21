package org.d3if4033.mobpro2.submission1.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "banyuwangi")
data class BanyuwangiEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name = "nama")
    var nama: String,

    @ColumnInfo(name = "deskripsi")
    var deskrpisi: String,

    @ColumnInfo(name = "like")
    var like: Int,

    @ColumnInfo(name = "gambar")
    var gambar: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)
