package rio.arj.imovie.features.main.popular

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import rio.arj.imovie.R
import rio.arj.imovie.databinding.FragmentPopularBinding
import rio.arj.imovie.features.detail.DetailMovieActivity
import rio.arj.imovie.features.main.MainAdapter

class PopularFragment : Fragment() {

  lateinit var viewModel: PopularViewModel
  lateinit var binding: FragmentPopularBinding
  lateinit var mainAdapter: MainAdapter

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    viewModel = ViewModelProvider(this).get(PopularViewModel::class.java)
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_popular, container, false)
    binding.viewModel = viewModel
    binding.lifecycleOwner = this

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    observer()
  }

  private fun observer() {
    viewModel.movieList.observe(this, {
      if (it != null) {
        mainAdapter = MainAdapter { movieId ->
          goto(DetailMovieActivity::class.java, movieId)
        }
        mainAdapter.submitList(it)

        binding.recyclerMovie.apply {
          layoutManager = LinearLayoutManager(requireContext())
          adapter = mainAdapter
        }
      }
    })
  }

  private fun <T> goto(clazz: Class<T>, movieId: Int) {
    val intent = Intent(binding.root.context, clazz)
    intent.putExtra(DetailMovieActivity.EXTRA_MOVIE_ID, movieId)
    startActivity(intent)
  }
}