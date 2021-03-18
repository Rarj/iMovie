package rio.arj.imovie.features.favorite

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import rio.arj.imovie.R
import rio.arj.imovie.databinding.ActivityFavoriteBinding
import rio.arj.imovie.features.detail.DetailMovieActivity

class FavoriteActivity : AppCompatActivity() {
  lateinit var viewModel: FavoriteViewModel
  lateinit var binding: ActivityFavoriteBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    viewModel = ViewModelProvider(this).get(FavoriteViewModel::class.java)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_favorite)
    binding.viewModel = viewModel
    binding.lifecycleOwner = this

    binding.toolbar.setNavigationOnClickListener { finish() }

    observe()
  }

  private fun observe() {
    viewModel.listFavorite.observe(this, {
      val adapterFavorite = FavoriteAdapter(it) { movieId ->
        goto(DetailMovieActivity::class.java, movieId)
      }
      binding.recyclerMovie.apply {
        layoutManager = LinearLayoutManager(this@FavoriteActivity)
        adapter = adapterFavorite
      }
    })
  }

  private fun <T> goto(clazz: Class<T>, movieId: Int) {
    val intent = Intent(binding.root.context, clazz)
    intent.putExtra("FAVORITE", true)
    intent.putExtra(DetailMovieActivity.EXTRA_MOVIE_ID, movieId)
    startActivityForResult(intent, 1)
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)

    if (requestCode == 1 && resultCode == RESULT_OK) {
      viewModel.getAllFavorite()
    }
  }

}