package rio.arj.imovie.repository.detail

import io.reactivex.Observable
import rio.arj.imovie.repository.detail.model.DetailResult

interface DetailRepository {
  fun getDetailMovie(detailId: Int): Observable<DetailResult>
}