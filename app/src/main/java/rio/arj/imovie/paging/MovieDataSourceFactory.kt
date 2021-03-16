package rio.arj.imovie.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import io.reactivex.disposables.CompositeDisposable
import rio.arj.imovie.network.ApiService
import rio.arj.imovie.repository.list.model.Result

class MovieDataSourceFactory(
  private val apiService: ApiService,
  private val compositeDisposable: CompositeDisposable
) : DataSource.Factory<Long, Result>() {

  val newsDataSourceLiveData = MutableLiveData<MovieDataSource>()

  override fun create(): DataSource<Long, Result> {
    val newsDataSource = MovieDataSource(apiService, compositeDisposable)
    newsDataSourceLiveData.postValue(newsDataSource)
    return newsDataSource
  }
}