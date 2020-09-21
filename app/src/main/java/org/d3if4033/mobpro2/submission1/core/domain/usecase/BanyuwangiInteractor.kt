package org.d3if4033.mobpro2.submission1.core.domain.usecase

import org.d3if4033.mobpro2.submission1.core.domain.model.Banyuwangi
import org.d3if4033.mobpro2.submission1.core.domain.repository.IBanyuwangiRepository


class BanyuwangiInteractor(private val banyuwangiRepository: IBanyuwangiRepository): BanyuwangiUseCase {

    override fun getAllBanyuwangi() = banyuwangiRepository.getAllBanyuwangi()

    override fun getFavoriteBanyuwangi() = banyuwangiRepository.getFavoriteBanyuwangi()

    override fun setFavoriteBanyuwangi(banyuwangi: Banyuwangi, state: Boolean) = banyuwangiRepository.setFavoriteBanyuwangi(banyuwangi, state)
}