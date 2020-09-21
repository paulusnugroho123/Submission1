package org.d3if4033.mobpro2.submission1.di

import org.d3if4033.mobpro2.submission1.core.domain.usecase.BanyuwangiInteractor
import org.d3if4033.mobpro2.submission1.core.domain.usecase.BanyuwangiUseCase
import org.d3if4033.mobpro2.submission1.detail.DetailBanyuwangiViewModel
import org.d3if4033.mobpro2.submission1.favorite.FavoriteViewModel
import org.d3if4033.mobpro2.submission1.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<BanyuwangiUseCase> { BanyuwangiInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { DetailBanyuwangiViewModel(get()) }
}