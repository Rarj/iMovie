package rio.arj.imovie.repository.list

import io.reactivex.Observable
import rio.arj.imovie.repository.list.model.ListResponse

interface ListRepository {
  fun getPopular(page: Int): Observable<ListResponse>
  fun getUpcoming(page: Int): Observable<ListResponse>
  fun getTopRated(page: Int): Observable<ListResponse>
  fun getNowPlaying(page: Int): Observable<ListResponse>
}