package rio.arj.imovie.repository.favorite.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import rio.arj.imovie.utils.DateUtils

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
) {
  fun getReleaseDateFormatted(): String {
    return if (releaseDate?.isBlank() == true || releaseDate == null) {
      "Unknown"
    } else {
      DateUtils().formatDate("dd MMMM yyyy", releaseDate)
    }
  }
}
