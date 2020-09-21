package org.d3if4033.mobpro2.submission1.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import org.d3if4033.mobpro2.submission1.core.domain.usecase.BanyuwangiUseCase

class HomeViewModel(banyuwangiUseCase: BanyuwangiUseCase) : ViewModel() {
    val banyuwangi = banyuwangiUseCase.getAllBanyuwangi().asLiveData()
}

