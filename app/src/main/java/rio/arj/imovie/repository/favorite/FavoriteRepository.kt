package rio.arj.imovie.repository.favorite

import io.reactivex.Observable
import rio.arj.imovie.repository.favorite.entity.DetailMovieEntity

interface FavoriteRepository {
  fun addToFavorite(detailMovie: DetailMovieEntity)
  fun findDetailById(movieId: Int): Observable<Boolean>
  fun deleteMovieById(movieId: Int): Observable<Boolean>
  fun getAllFavoriteMovie(): Observable<List<DetailMovieEntity>>
}
