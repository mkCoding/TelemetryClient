package com.example.telemetryclient.di

import com.example.telemetryclient.data.api.ApiDetails
import com.example.telemetryclient.data.api.WebHookApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(ApiDetails.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun providesWebHookApi(retrofit: Retrofit): WebHookApi{
        return retrofit.create(WebHookApi::class.java)
    }

}