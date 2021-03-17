package rio.arj.imovie.repository.favorite

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import rio.arj.imovie.AppDatabase
import rio.arj.imovie.MovieApplication
import rio.arj.imovie.repository.favorite.dao.DetailMovieDao
import rio.arj.imovie.repository.favorite.entity.DetailMovieEntity

class FavoriteRepositoryImpl : FavoriteRepository {

  private val database = AppDatabase.getAppDataBase(MovieApplication.applicationContext())
  private var favoriteDao: DetailMovieDao? = database?.detailMovieDao()

  override fun addToFavorite(detailMovie: DetailMovieEntity) {
    Observable.fromCallable {
      favoriteDao?.addToFavorite(detailMovie)
    }.subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe()
  }

  override fun findDetailById(movieId: Int): Observable<Boolean> {
    return Observable.fromCallable {
      favoriteDao?.getMovieById(movieId)
    }.subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .map {
        it.isNotEmpty()
      }
  }

  override fun deleteMovieById(movieId: Int): Observable<Boolean> {
    return Observable.fromCallable {
      favoriteDao?.deleteMovieById(movieId)
    }.subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .map { true }
  }
}