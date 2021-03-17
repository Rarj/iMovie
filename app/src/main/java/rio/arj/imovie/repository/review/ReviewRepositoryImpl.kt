package rio.arj.imovie.repository.review

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import rio.arj.imovie.network.ApiService
import rio.arj.imovie.network.NetworkBuilder
import rio.arj.imovie.repository.review.model.ReviewResponse

class ReviewRepositoryImpl(
  private val apiService: ApiService
) : ReviewRepository {

  override fun getReviews(movieId: Int, page: Int): Observable<ReviewResponse> {
    return apiService.getReviews(movieId, page, NetworkBuilder().API_KEY)
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
  }
}