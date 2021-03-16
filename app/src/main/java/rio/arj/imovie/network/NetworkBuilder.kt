package rio.arj.imovie.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkBuilder {

  private val BASE_URL = "https://api.themoviedb.org/3/movie/"
  val BASE_URL_IMAGE = "https://image.tmdb.org/t/p/w342"
  val API_KEY = "e453f10d64792f6589dafa2c98d57de0"

  private fun getRetrofitClient(): Retrofit {
    return Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      .build()
  }

  fun getEndpoint(): ApiService {
    return getRetrofitClient().create(ApiService::class.java)
  }

}