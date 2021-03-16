package rio.arj.imovie.repository.list

import io.reactivex.Observable
import rio.arj.imovie.repository.list.model.ListResponse

interface ListRepository {
  fun getPopular(): Observable<ListResponse>
}