package com.steradiantest.car.module

import com.steradiantest.car.data.ApiServices
import com.steradiantest.car.data.repositories.CarsRepository
import com.steradiantest.car.data.repositories.OrdersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): ApiServices {
        return Retrofit.Builder()
            .baseUrl("https://67037f39bd7c8c1ccd41a62e.mockapi.io/rent-car/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiServices::class.java)
    }

    @Provides
    @Singleton
    fun provideCarsRepository(apiServices: ApiServices): CarsRepository {
        return CarsRepository(apiServices)
    }

    @Provides
    @Singleton
    fun provideOrdersRepository(apiServices: ApiServices): OrdersRepository {
        return OrdersRepository(apiServices)
    }
}