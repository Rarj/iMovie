package rio.arj.imovie.repository.list.model

import com.google.gson.annotations.SerializedName

data class Result(
  @SerializedName("adult")
  val adult: Boolean?
//  val id: Int
//  val overview: String,
//  @SerializedName("poster_path")
//  val posterPath: String?,
//  @SerializedName("release_date")
//  val releaseDate: String,
//  val title: String,
//  @SerializedName("vote_average")
//  val voteAverage: Double
)