package rio.arj.imovie.repository.detail

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import rio.arj.imovie.network.ApiService
import rio.arj.imovie.network.NetworkBuilder
import rio.arj.imovie.repository.detail.model.DetailResponse

class DetailRepositoryImpl(private val apiService: ApiService) : DetailRepository {

  override fun getDetailMovie(detailId: Int): Observable<DetailResponse> {
    return apiService.getDetailMovie(NetworkBuilder().API_KEY, detailId)
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
  }

}