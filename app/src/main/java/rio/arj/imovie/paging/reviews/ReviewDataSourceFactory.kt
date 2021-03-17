package rio.arj.imovie.paging.reviews

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import io.reactivex.disposables.CompositeDisposable
import rio.arj.imovie.network.ApiService
import rio.arj.imovie.repository.review.model.Result

class ReviewDataSourceFactory(
  private var movieId: Int,
  private val apiService: ApiService,
  private val compositeDisposable: CompositeDisposable
) : DataSource.Factory<Long, Result>() {

  val reviewDataSourceLiveData = MutableLiveData<ReviewDataSource>()

  override fun create(): DataSource<Long, Result> {
    val newsDataSource = ReviewDataSource(movieId, apiService, compositeDisposable)
    reviewDataSourceLiveData.postValue(newsDataSource)
    return newsDataSource
  }
}