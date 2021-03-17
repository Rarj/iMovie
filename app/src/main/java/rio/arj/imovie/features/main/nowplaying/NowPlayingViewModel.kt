package rio.arj.imovie.features.main.nowplaying

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import io.reactivex.disposables.CompositeDisposable
import rio.arj.imovie.network.NetworkBuilder
import rio.arj.imovie.paging.MovieDataSourceFactory
import rio.arj.imovie.repository.list.model.Result

class NowPlayingViewModel : ViewModel() {

  private val compositeDisposable = CompositeDisposable()
  private val apiService = NetworkBuilder().getEndpoint()

  lateinit var movieList: LiveData<PagedList<Result>>
  lateinit var movieDataSourceFactory: MovieDataSourceFactory

  init {
    reloadMovie("4")
  }

  fun reloadMovie(categoryId: String) {
    movieDataSourceFactory = MovieDataSourceFactory(categoryId, apiService, compositeDisposable)
    val config = PagedList.Config.Builder()
      .setPageSize(20)
      .setInitialLoadSizeHint(20 * 2)
      .setEnablePlaceholders(true)
      .build()
    movieList = LivePagedListBuilder(movieDataSourceFactory, config).build()
  }

}