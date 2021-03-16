package rio.arj.imovie.repository.list.model

import com.google.gson.annotations.SerializedName
import rio.arj.imovie.utils.DateUtils

data class Result(
  val id: Int,
  val overview: String,
  @SerializedName("poster_path")
  val posterPath: String?,
  @SerializedName("release_date")
  val releaseDate: String,
  val title: String,
  @SerializedName("vote_average")
  val voteAverage: Double
) {
  fun getReleaseDateFormatted() = DateUtils().formatDate("dd MMMM yyyy", releaseDate)
}