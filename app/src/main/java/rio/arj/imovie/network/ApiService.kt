package rio.arj.imovie.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rio.arj.imovie.repository.detail.model.DetailResult
import rio.arj.imovie.repository.list.model.ListResponse
import rio.arj.imovie.repository.review.model.ReviewResponse

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
    @Path("movie_id") movieId: Int,
    @Query("api_key") api_key: String
  ): Observable<DetailResult>

  @GET("{movie_id}/reviews")
  fun getReviews(
    @Path("movie_id") movieId: Int,
    @Query("page") page: Int,
    @Query("api_key") api_key: String
  ): Observable<ReviewResponse>

}