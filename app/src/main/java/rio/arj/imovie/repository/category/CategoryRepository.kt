package rio.arj.imovie.repository.category

import rio.arj.imovie.repository.category.model.CategoryResponse

interface CategoryRepository {
  fun getCategory(): MutableList<CategoryResponse>
}