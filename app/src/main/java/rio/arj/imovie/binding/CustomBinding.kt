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

}