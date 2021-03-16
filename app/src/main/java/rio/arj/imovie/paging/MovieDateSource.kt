package rio.arj.imovie.paging

import androidx.paging.PageKeyedDataSource
import io.reactivex.disposables.CompositeDisposable
import rio.arj.imovie.network.ApiService
import rio.arj.imovie.repository.list.ListRepositoryImpl
import rio.arj.imovie.repository.list.model.Result

class MovieDateSource(
  private val apiService: ApiService,
  private val compositeDisposable: CompositeDisposable
) : PageKeyedDataSource<Long, Result>() {

  val repository = ListRepositoryImpl(apiService)

  override fun loadInitial(
    params: LoadInitialParams<Long>,
    callback: LoadInitialCallback<Long, Result>
  ) {
    compositeDisposable.add(
      repository.getPopular(1)
        .subscribe({ response ->
          callback.onResult(response.results?.toList() as MutableList<Result>, null, 2)
        }, {

        })
    )
  }

  override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Long, Result>) {

  }

  override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Long, Result>) {
    compositeDisposable.add(
      repository.getPopular(params.key.toInt())
        .subscribe({ response ->
          callback.onResult(response.results?.toList() as MutableList<Result>, params.key + 1)
        }, {

        })
    )
  }
}