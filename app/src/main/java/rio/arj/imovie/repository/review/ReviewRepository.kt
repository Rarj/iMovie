package rio.arj.imovie.repository.review

import io.reactivex.Observable
import rio.arj.imovie.repository.review.model.ReviewResponse

interface ReviewRepository {
  fun getReviews(movieId: Int, page: Int): Observable<ReviewResponse>
}