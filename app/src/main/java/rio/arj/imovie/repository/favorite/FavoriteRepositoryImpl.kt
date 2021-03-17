package rio.arj.imovie.repository.favorite

import rio.arj.imovie.MovieApplication
import rio.arj.imovie.repository.favorite.dao.DetailMovieDao
import rio.arj.imovie.repository.favorite.entity.DetailMovieEntity

class FavoriteRepositoryImpl : FavoriteRepository {

  var favoriteDao: DetailMovieDao? = MovieApplication().database?.detailMovieDao()

  override fun addToFavorite(detailMovie: DetailMovieEntity) {

  }

}