package rio.arj.imovie.features.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import rio.arj.imovie.network.NetworkBuilder
import rio.arj.imovie.repository.detail.DetailRepositoryImpl
import rio.arj.imovie.repository.detail.model.DetailResult
import rio.arj.imovie.repository.favorite.FavoriteRepositoryImpl
import rio.arj.imovie.repository.favorite.entity.DetailMovieEntity

class DetailMovieViewModel : ViewModel() {

  val compositeDisposable = CompositeDisposable()

  var detailMovie = MutableLiveData<DetailResult>()
    private set

  var isMovieFavorited = MutableLiveData(false)
    private set

  fun setFavorite(checked: Boolean) {
    isMovieFavorited.value = checked
  }

  fun getDetailMovie(id: Int) {
    val compositeDisposable = CompositeDisposable()
    compositeDisposable.add(
      DetailRepositoryImpl(NetworkBuilder().getEndpoint())
        .getDetailMovie(id)
        .subscribe({
          detailMovie.value = it
        }, {
        })
    )
  }

  fun addToFavorite() {
    val value = detailMovie.value ?: throw Exception("detail movie must not null")
    FavoriteRepositoryImpl().addToFavorite(
      DetailMovieEntity(
        id = value.id,
        overview = value.overview,
        posterPath = value.posterPath,
        releaseDate = value.releaseDate,
        title = value.title,
        voteAverage = value.voteAverage
      )
    )
  }

  fun deleteFavorite(movieId: Int) {
    compositeDisposable.add(
      FavoriteRepositoryImpl().deleteMovieById(movieId)
        .subscribe {
          isMovieFavorited.value = false
        }
    )
  }

  fun findMovieById(movieId: Int) {
    compositeDisposable.add(
      FavoriteRepositoryImpl().findDetailById(movieId)
        .subscribe(
          {
            isMovieFavorited.value = it
          }, {

          }
        )
    )
  }

  override fun onCleared() {
    super.onCleared()
    compositeDisposable.clear()
  }

}