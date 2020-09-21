package org.d3if4033.mobpro2.submission1.detail

import androidx.lifecycle.ViewModel
import org.d3if4033.mobpro2.submission1.core.domain.model.Banyuwangi
import org.d3if4033.mobpro2.submission1.core.domain.usecase.BanyuwangiUseCase

class DetailBanyuwangiViewModel(private val banyuwangiUseCase: BanyuwangiUseCase) : ViewModel() {
    fun setFavoriteBanyuwangi(banyuwangi: Banyuwangi, newStatus:Boolean) =
        banyuwangiUseCase.setFavoriteBanyuwangi(banyuwangi, newStatus)
}

