package rio.arj.imovie.repository.detail

import io.reactivex.Observable
import rio.arj.imovie.repository.detail.model.DetailResponse

interface DetailRepository {
  fun getDetailMovie(detailId: Int): Observable<DetailResponse>
}