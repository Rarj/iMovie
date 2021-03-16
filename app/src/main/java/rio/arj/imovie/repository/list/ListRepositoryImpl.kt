package rio.arj.imovie.repository.list

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import rio.arj.imovie.network.ApiService
import rio.arj.imovie.network.NetworkBuilder
import rio.arj.imovie.repository.list.model.ListResponse

class ListRepositoryImpl(private val apiService: ApiService) : ListRepository {
  override fun getPopular(): Observable<ListResponse> {
    return apiService.getPopularMovie(NetworkBuilder().API_KEY)
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
  }
}