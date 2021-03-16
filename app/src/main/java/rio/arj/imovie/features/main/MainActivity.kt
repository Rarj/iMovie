package rio.arj.imovie.features.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import rio.arj.imovie.R
import rio.arj.imovie.databinding.ActivityMainBinding
import rio.arj.imovie.repository.list.model.ListResponse


class MainActivity : AppCompatActivity() {

  lateinit var viewModel: MainViewModel
  lateinit var binding: ActivityMainBinding

  lateinit var mainAdapter: MainAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    binding.viewModel = viewModel
    binding.lifecycleOwner = this

    viewModel.getPopularMovie()

    observer()
  }

  private fun setAdapter(movieList: ListResponse) {
    mainAdapter = MainAdapter(movieList)

    binding.recyclerMovie.apply {
      layoutManager = LinearLayoutManager(this@MainActivity)
      adapter = mainAdapter
    }
  }

  private fun observer() {
    viewModel.listResponse.observe(this, {
      if (it != null) {
        setAdapter(it)
      }
    })
  }
}