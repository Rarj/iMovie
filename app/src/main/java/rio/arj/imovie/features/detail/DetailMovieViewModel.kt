package rio.arj.imovie.features.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import rio.arj.imovie.network.NetworkBuilder
import rio.arj.imovie.repository.detail.DetailRepositoryImpl
import rio.arj.imovie.repository.detail.model.DetailResult

class DetailMovieViewModel : ViewModel() {

  var detailMovie = MutableLiveData<DetailResult>()
    private set

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

}