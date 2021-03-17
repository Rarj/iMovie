package rio.arj.imovie.repository.detail.model

import com.google.gson.annotations.SerializedName
import rio.arj.imovie.utils.DateUtils

data class DetailResult(
  val id: Int,
  val overview: String,
  @SerializedName("poster_path")
  val posterPath: String?,
  @SerializedName("release_date")
  val releaseDate: String?,
  val title: String,
  @SerializedName("vote_average")
  val voteAverage: Double
) {
  fun getReleaseDateFormatted(): String {
    return if (releaseDate?.isBlank() == true || releaseDate == null) {
      "Unknown"
    } else {
      DateUtils().formatDate("dd MMMM yyyy", releaseDate)
    }
  }
}