package org.d3if4033.mobpro2.submission1.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData

import org.d3if4033.mobpro2.submission1.core.domain.usecase.BanyuwangiUseCase

class FavoriteViewModel(banyuwangiUseCase: BanyuwangiUseCase) : ViewModel() {
    val favoriteBanyuwangi = banyuwangiUseCase.getFavoriteBanyuwangi().asLiveData()
}

