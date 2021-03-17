package rio.arj.imovie.features.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import rio.arj.imovie.R
import rio.arj.imovie.databinding.ActivityDetailMovieBinding

class DetailMovieActivity : AppCompatActivity() {

  lateinit var viewModel: DetailMovieViewModel
  lateinit var binding: ActivityDetailMovieBinding

  val movieId by lazy {
    intent.getIntExtra(EXTRA_MOVIE_ID, -1)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    viewModel = ViewModelProvider(this).get(DetailMovieViewModel::class.java)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_movie)
    binding.viewModel = viewModel
    binding.lifecycleOwner = this

    viewModel.getDetailMovie(movieId)
    viewModel.findMovieById(movieId)

    listener()
    observer()
  }

  private fun listener() {
    binding.toolbar.setNavigationOnClickListener { finish() }

    binding.buttonAddToFavorite.setOnClickListener {
      if (viewModel.isMovieFavorited.value == true) {
        viewModel.deleteFavorite(movieId)
      } else {
        viewModel.addToFavorite()
      }

      viewModel.setFavorite(!viewModel.isMovieFavorited.value!!)
    }
  }

  private fun observer() {
    with(viewModel) {
      detailMovie.observe(this@DetailMovieActivity, { detailMovie ->
        binding.isLoaded = detailMovie != null
      })

      isMovieFavorited.observe(this@DetailMovieActivity, {
        if (it) {
          binding.buttonAddToFavorite.setImageDrawable(
            ContextCompat.getDrawable(this@DetailMovieActivity, R.drawable.ic_favorite_filled_red)
          )
        } else {
          binding.buttonAddToFavorite.setImageDrawable(
            ContextCompat.getDrawable(this@DetailMovieActivity, R.drawable.ic_favorite_border_red)
          )
        }
      })
    }
  }

  companion object {
    const val EXTRA_MOVIE_ID = "movie_id"
  }
}