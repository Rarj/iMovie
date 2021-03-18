package rio.arj.imovie.repository.favorite.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import rio.arj.imovie.repository.detail.model.DetailResult
import rio.arj.imovie.repository.favorite.entity.DetailMovieEntity

@Dao
interface DetailMovieDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun addToFavorite(detailMovie: DetailMovieEntity)

  @Query("SELECT * FROM DetailMovieEntity WHERE id=:movieId")
  fun getMovieById(movieId: Int): List<DetailResult>

  @Query("DELETE FROM DetailMovieEntity WHERE id=:movieId")
  fun deleteMovieById(movieId: Int)

  @Query("SELECT * FROM DetailMovieEntity")
  fun getAllFavoriteMovie(): List<DetailMovieEntity>

}