package rio.arj.imovie.repository.favorite.dao

import androidx.room.Dao
import androidx.room.Insert
import rio.arj.imovie.repository.favorite.entity.DetailMovieEntity

@Dao
interface DetailMovieDao {

  @Insert
  fun addToFavorite(detailMovie: DetailMovieEntity)

}