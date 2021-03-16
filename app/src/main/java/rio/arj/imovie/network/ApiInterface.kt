package rio.arj.imovie.network

import io.reactivex.Observable
import retrofit2.http.GET
import rio.arj.imovie.repository.list.model.ListResponse

interface ApiInterface {

  @GET("popular?api_key=e453f10d64792f6589dafa2c98d57de0")
  fun getPopularMovie(): Observable<ListResponse>

}