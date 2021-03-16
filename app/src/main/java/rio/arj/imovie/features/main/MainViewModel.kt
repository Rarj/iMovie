package rio.arj.imovie.features.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import rio.arj.imovie.network.NetworkBuilder
import rio.arj.imovie.repository.list.ListRepositoryImpl
import rio.arj.imovie.repository.list.model.ListResponse

class MainViewModel : ViewModel() {

  private val compositeDisposable = CompositeDisposable()
  private val apiService = NetworkBuilder().getEndpoint()
  private val repository = ListRepositoryImpl(apiService)

  var listResponse = MutableLiveData<ListResponse>()
    private set

  fun getPopularMovie() {
    compositeDisposable.add(
      repository.getPopular()
        .subscribe({
          listResponse.value = it
        }, {

        })
    )
  }

}