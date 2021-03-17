package rio.arj.imovie.repository.favorite

import rio.arj.imovie.repository.favorite.entity.DetailMovieEntity

interface FavoriteRepository {
  fun addToFavorite(detailMovie: DetailMovieEntity)
}
