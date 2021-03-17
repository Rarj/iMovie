package rio.arj.imovie.features.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import rio.arj.imovie.R

class DetailMovieActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail_movie)
  }

  companion object {
    const val EXTRA_MOVIE_ID = "movie_id"
  }
}