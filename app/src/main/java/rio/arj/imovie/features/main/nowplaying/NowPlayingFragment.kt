package rio.arj.imovie.features.main.nowplaying

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
import rio.arj.imovie.databinding.FragmentNowPlayingBinding
import rio.arj.imovie.features.detail.DetailMovieActivity
import rio.arj.imovie.features.main.MainAdapter

class NowPlayingFragment : Fragment() {

  lateinit var viewModel: NowPlayingViewModel
  lateinit var binding: FragmentNowPlayingBinding
  lateinit var mainAdapter: MainAdapter

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    viewModel = ViewModelProvider(this).get(NowPlayingViewModel::class.java)
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_now_playing, container, false)
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