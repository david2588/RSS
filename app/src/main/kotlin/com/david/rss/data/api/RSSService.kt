package com.david.rss.data.api

import me.toptas.rssconverter.RssFeed
import retrofit2.Call
import retrofit2.http.GET

interface RssService {

  @GET("futbol/primera-division.xml")
  fun getRss(): Call<RssFeed>
}
