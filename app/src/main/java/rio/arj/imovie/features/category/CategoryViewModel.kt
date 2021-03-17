package rio.arj.imovie.features.category

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import rio.arj.imovie.repository.category.CategoryRepositoryImpl
import rio.arj.imovie.repository.category.model.CategoryResponse

class CategoryViewModel : ViewModel() {

  var listCategory = MutableLiveData<List<CategoryResponse>>()
    private set

  fun getCategoryList() {
    listCategory.value = CategoryRepositoryImpl().getCategory()

  }

}