package rio.arj.imovie.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import rio.arj.imovie.repository.list.model.ListResponse

interface ApiService {

  @GET("popular")
  fun getPopularMovie(@Query("api_key") api_key: String): Observable<ListResponse>

}