package rio.arj.imovie.repository.review.model

import com.google.gson.annotations.SerializedName

data class AuthorDetails(
  @SerializedName("avatar_path")
  val avatarPath: String?,
  val name: String?
) {
  fun authorName(): String {
    return if (name.isNullOrBlank()) {
      "Unknown"
    } else {
      name
    }
  }
}