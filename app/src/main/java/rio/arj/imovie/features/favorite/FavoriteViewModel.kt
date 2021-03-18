package rio.arj.imovie.features.favorite

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import rio.arj.imovie.repository.favorite.FavoriteRepositoryImpl
import rio.arj.imovie.repository.favorite.entity.DetailMovieEntity

class FavoriteViewModel : ViewModel() {

  private var compositeDisposable = CompositeDisposable()

  var listFavorite = MutableLiveData<List<DetailMovieEntity>>()
    private set

  init {
    getAllFavorite()
  }

  fun getAllFavorite() {
    compositeDisposable.add(
      FavoriteRepositoryImpl().getAllFavoriteMovie()
        .subscribe({
          listFavorite.value = it
        }, {

        })
    )
  }

  override fun onCleared() {
    super.onCleared()
    compositeDisposable.clear()
  }

}