package rio.arj.imovie.repository.review.model

import com.google.gson.annotations.SerializedName
import rio.arj.imovie.utils.DateUtils

data class Result(
  @SerializedName("author_details")
  val authorDetails: AuthorDetails?,
  val content: String?,
  val id: String?,
  val url: String?,
  @SerializedName("created_at")
  val createdAt: String?
) {
  fun getFormattedDate() = DateUtils().formatDate(
    pattern = "dd MMMM yyyy",
    date = (createdAt ?: System.currentTimeMillis()).toString()
  )
}