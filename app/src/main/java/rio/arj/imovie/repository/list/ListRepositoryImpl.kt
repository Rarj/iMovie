package rio.arj.imovie.repository.list

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import rio.arj.imovie.network.ApiInterface
import rio.arj.imovie.repository.list.model.ListResponse

class ListRepositoryImpl(private val apiService: ApiInterface) : ListRepository {
  override fun getPopular(): Observable<ListResponse> {
    return apiService.getPopularMovie()
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
  }
}