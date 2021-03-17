package rio.arj.imovie.features.main.toprated

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import rio.arj.imovie.R
import rio.arj.imovie.databinding.FragmentTopRatedBinding
import rio.arj.imovie.features.main.MainAdapter

class TopRatedFragment : Fragment() {

  lateinit var viewModel: TopRatedViewModel
  lateinit var binding: FragmentTopRatedBinding
  lateinit var mainAdapter: MainAdapter

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    viewModel = ViewModelProvider(this).get(TopRatedViewModel::class.java)
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_top_rated, container, false)
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
        mainAdapter = MainAdapter()
        mainAdapter.submitList(it)

        binding.recyclerMovie.apply {
          layoutManager = LinearLayoutManager(requireContext())
          adapter = mainAdapter
        }
      }
    })
  }
}