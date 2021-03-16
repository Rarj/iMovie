package rio.arj.imovie.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkBuilder {

  private val BASE_URL = "https://api.themoviedb.org/3/movie/"
  val API_KEY = "33ef4526082667e26fd77c6773694d55"

  private fun getRetrofitClient(): Retrofit {
    return Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      .build()
  }

  fun getEndpoint(): ApiInterface {
    return getRetrofitClient().create(ApiInterface::class.java)
  }

}