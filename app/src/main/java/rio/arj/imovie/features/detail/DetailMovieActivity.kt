package rio.arj.imovie.features.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import rio.arj.imovie.R
import rio.arj.imovie.databinding.ActivityDetailMovieBinding

class DetailMovieActivity : AppCompatActivity() {

  lateinit var viewModel: DetailMovieViewModel
  lateinit var binding: ActivityDetailMovieBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    viewModel = ViewModelProvider(this).get(DetailMovieViewModel::class.java)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_movie)
    binding.viewModel = viewModel
    binding.lifecycleOwner = this

    viewModel.getDetailMovie(intent.getIntExtra(EXTRA_MOVIE_ID, -1))

    listener()
    observer()
  }

  private fun listener() {
    binding.toolbar.setNavigationOnClickListener { finish() }
  }

  private fun observer() {
    viewModel.detailMovie.observe(this, { detailMovie ->
      binding.isLoaded = detailMovie != null
    })
  }

  companion object {
    const val EXTRA_MOVIE_ID = "movie_id"
  }
}