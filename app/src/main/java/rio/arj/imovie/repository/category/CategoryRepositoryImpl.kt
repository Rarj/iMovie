package rio.arj.imovie.repository.category

import rio.arj.imovie.repository.category.model.CategoryResponse

class CategoryRepositoryImpl : CategoryRepository {

  override fun getCategory(): MutableList<CategoryResponse> {
    return mutableListOf(
      CategoryResponse(id = "1", name = "Popular"),
      CategoryResponse(id = "2", name = "Upcoming"),
      CategoryResponse(id = "3", name = "Top Rated"),
      CategoryResponse(id = "4", name = "Now Playing"),
    )
  }
}