package rio.arj.imovie.repository.favorite.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DetailMovieEntity(
  @PrimaryKey
  val id: Int,
  val overview: String,
  val posterPath: String?,
  val releaseDate: String?,
  val title: String,
  val voteAverage: Double,
  val dateAdded: String = System.currentTimeMillis().toString()
)
