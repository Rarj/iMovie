package rio.arj.imovie.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rio.arj.imovie.repository.detail.model.DetailResponse
import rio.arj.imovie.repository.list.model.ListResponse

interface ApiService {

  @GET("popular")
  fun getPopularMovie(
    @Query("api_key") api_key: String,
    @Query("page") page: Int
  ): Observable<ListResponse>

  @GET("upcoming")
  fun getUpcomingMovie(
    @Query("api_key") api_key: String,
    @Query("page") page: Int
  ): Observable<ListResponse>

  @GET("top_rated")
  fun getTopRatedMovie(
    @Query("api_key") api_key: String,
    @Query("page") page: Int
  ): Observable<ListResponse>

  @GET("now_playing")
  fun getNowPlayingMovie(
    @Query("api_key") api_key: String,
    @Query("page") page: Int
  ): Observable<ListResponse>

  @GET("{movie_id}}")
  fun getDetailMovie(
    @Query("api_key") api_key: String,
    @Path("movie_id") movieId: Int
  ): Observable<DetailResponse>


}