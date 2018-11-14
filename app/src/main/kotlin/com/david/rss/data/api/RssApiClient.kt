package com.david.rss.data.api

import android.content.res.Resources
import me.toptas.rssconverter.RssConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.funktionale.either.Either
import retrofit2.Call
import retrofit2.Retrofit
import java.io.IOException

class RssApiClient constructor(baseUrl: String) {

  private var service: RssService

  init {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

    val clientBuilder = OkHttpClient.Builder()
    clientBuilder.addInterceptor(httpLoggingInterceptor)

    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(clientBuilder.build())
        .addConverterFactory(RssConverterFactory.create())
        .build()

    service = retrofit.create<RssService>(RssService::class.java)
  }

  fun getList() = callService {
    service.getRss()
  }

  private fun <T> callService(callback: () -> Call<T>): Either<Exception, T> {
    return try {
      val response = callback().execute()

      when {
        response.code() == 204 -> Either.left(Resources.NotFoundException())
        response.code() >= 400 -> Either.left(Exception())
        else -> Either.right(response.body())
      }
    } catch (exception: IOException) {
      Either.left(exception)
    }
  }
}
