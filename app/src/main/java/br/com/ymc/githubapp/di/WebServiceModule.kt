package br.com.ymc.githubapp.di

import br.com.ymc.githubapp.network.IRetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class WebServiceModule
{
    val BASE_URL = "https://api.github.com/search/"

    @Provides
    @Singleton
    fun getRetroServiceInstance(retrofit: Retrofit) : IRetrofitService
    {
        return retrofit.create(IRetrofitService::class.java)
    }

    @Provides
    @Singleton
    fun getRetrofitInstance(): Retrofit
    {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}