package rio.arj.imovie.binding

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import rio.arj.imovie.R
import rio.arj.imovie.network.NetworkBuilder
import rio.arj.imovie.utils.setImage

object CustomBinding {

  @JvmStatic
  @BindingAdapter("app:imageUrl")
  fun setImageUrl(imageView: AppCompatImageView, url: String?) {
    val urlImage = NetworkBuilder().BASE_URL_IMAGE + url
    if (url != null) {
      imageView.setImage(urlImage)
    } else {
      imageView.setImage(R.drawable.ic_photo_placeholder)
    }
  }

  @JvmStatic
  @BindingAdapter("app:avatarUrl")
  fun setAvatarUrl(imageView: AppCompatImageView, url: String?) {
    val convertedUrl = if (url.toString().contains("https")) {
      url?.removeRange(0, 1).toString()
    } else {
      NetworkBuilder().BASE_URL_AVATAR + url.toString()
    }

    if (url != null) {
      convertedUrl.let { imageView.setImage(it) }
    } else {
      imageView.setImage(R.drawable.ic_photo_placeholder)
    }
  }

}