package tom.dev.justnews.common

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import tom.dev.justnews.BuildConfig
import tom.dev.justnews.data.api.NewsApi
import javax.inject.Singleton

/*
 * Network module will be installed in Application scope
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesNewsApi(retrofit: Retrofit): NewsApi {
        return retrofit.create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.NEWS_API_BASE)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(getAuthInterceptor())
            if (BuildConfig.DEBUG) {
                addInterceptor(getHttpLoggingInterceptor())
            }
        }.build()
    }

    @Provides
    @Singleton
    fun providesMoshi(): Moshi {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }

    private fun getAuthInterceptor(): Interceptor {
        return Interceptor {
            val request = it.request()
                .newBuilder()
                .addHeader("X-Api-Key", BuildConfig.NEWS_API_KEY)
                .build()
            it.proceed(request)
        }
    }

    private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingLevel = HttpLoggingInterceptor.Level.BODY
        return HttpLoggingInterceptor().setLevel(loggingLevel)
    }
}