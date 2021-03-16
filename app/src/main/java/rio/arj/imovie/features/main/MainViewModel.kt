package rio.arj.imovie.features.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import io.reactivex.disposables.CompositeDisposable
import rio.arj.imovie.network.NetworkBuilder
import rio.arj.imovie.paging.MovieDataSourceFactory
import rio.arj.imovie.repository.list.model.Result

class MainViewModel : ViewModel() {

  private val compositeDisposable = CompositeDisposable()
  private val apiService = NetworkBuilder().getEndpoint()

  var movieList: LiveData<PagedList<Result>>
  private val movieDataSourceFactory: MovieDataSourceFactory

  init {
    movieDataSourceFactory = MovieDataSourceFactory(apiService, compositeDisposable)
    val config = PagedList.Config.Builder()
      .setPageSize(20)
      .setInitialLoadSizeHint(20 * 2)
      .setEnablePlaceholders(false)
      .build()
    movieList = LivePagedListBuilder(movieDataSourceFactory, config).build()
  }

}