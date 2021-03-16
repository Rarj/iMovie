package rio.arj.imovie.utils

import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

fun AppCompatImageView.setImage(any: Any) {
  Glide.with(this.context)
    .load(any)
    .into(this)
}