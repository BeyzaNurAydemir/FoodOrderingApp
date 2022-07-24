package com.beyzanuraydemir.foodorderingapp.di

import com.beyzanuraydemir.foodorderingapp.data.repo.YemeklerDaoRepository
import com.beyzanuraydemir.foodorderingapp.retrofit.ApiUtils
import com.beyzanuraydemir.foodorderingapp.retrofit.YemeklerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideYemeklerDaoRepository(ydao:YemeklerDao) : YemeklerDaoRepository{
        return YemeklerDaoRepository(ydao)
    }

    @Provides
    @Singleton
    fun provideYemeklerDao() : YemeklerDao{
        return ApiUtils.getYemeklerDao()
    }
}