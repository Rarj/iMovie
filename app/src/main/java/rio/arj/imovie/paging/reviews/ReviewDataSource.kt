package rio.arj.imovie.paging.reviews

import androidx.paging.PageKeyedDataSource
import io.reactivex.disposables.CompositeDisposable
import rio.arj.imovie.network.ApiService
import rio.arj.imovie.repository.review.ReviewRepositoryImpl

class ReviewDataSource(
  private val movieId: Int,
  apiService: ApiService,
  private val compositeDisposable: CompositeDisposable
) : PageKeyedDataSource<Long, rio.arj.imovie.repository.review.model.Result>() {

  val repository = ReviewRepositoryImpl(apiService)

  override fun loadInitial(
    params: LoadInitialParams<Long>,
    callback: LoadInitialCallback<Long, rio.arj.imovie.repository.review.model.Result>
  ) {
    compositeDisposable.add(
      repository.getReviews(movieId, 1)
        .subscribe({ response ->
          callback.onResult(response.results.toList(), null, 2)
        }, {})
    )
  }

  override fun loadAfter(
    params: LoadParams<Long>,
    callback: LoadCallback<Long, rio.arj.imovie.repository.review.model.Result>
  ) {
    compositeDisposable.add(
      repository.getReviews(movieId, params.key.toInt())
        .subscribe({ response ->
          callback.onResult(response.results.toList(), params.key + 1)
        }, {

        })
    )
  }

  override fun loadBefore(
    params: LoadParams<Long>,
    callback: LoadCallback<Long, rio.arj.imovie.repository.review.model.Result>
  ) {
  }
}