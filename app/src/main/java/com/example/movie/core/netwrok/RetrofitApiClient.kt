package com.example.movie.core.netwrok

import com.example.movie.BuildConfig.BASE_URL
import com.example.movie.data.remote.ApiService
import com.readystatesoftware.chuck.ChuckInterceptor
import com.squareup.moshi.FromJson
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.math.BigDecimal

val networkModule = module {
    factory { ChuckInterceptor(androidContext()) }
    factory { provideOkHttpClient(get()) }
    factory { provideApi(get()) }
    factory { provideMoshi() }
    single { provideRetrofit(get(), get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
}

fun provideOkHttpClient(
    chuckInterceptor: ChuckInterceptor
): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

    return OkHttpClient().newBuilder()
        .addInterceptor(chuckInterceptor)
        .addInterceptor(interceptor)
        .build()
}

fun provideMoshi(): Moshi {
    return Moshi.Builder()
        .add(BigDecimalAdapter)
        .add(KotlinJsonAdapterFactory())
        .build()
}

fun provideApi(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

object BigDecimalAdapter {
    @FromJson
    fun fromJson(string: String) = BigDecimal(string)

    @ToJson
    fun toJson(value: BigDecimal) = value.toString()
}