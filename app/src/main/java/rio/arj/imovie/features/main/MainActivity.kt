package rio.arj.imovie.features.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import rio.arj.imovie.R

class MainActivity : AppCompatActivity() {

  lateinit var viewModel: MainViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    viewModel.getPopularMovie()
  }
}