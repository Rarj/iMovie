package rio.arj.imovie.features.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import rio.arj.imovie.R
import rio.arj.imovie.databinding.ActivityMainBinding
import rio.arj.imovie.features.category.CategoryBottomSheet
import rio.arj.imovie.features.main.nowplaying.NowPlayingFragment
import rio.arj.imovie.features.main.popular.PopularFragment
import rio.arj.imovie.features.main.toprated.TopRatedFragment
import rio.arj.imovie.features.main.upcoming.UpcomingFragment


class MainActivity : AppCompatActivity() {

  lateinit var binding: ActivityMainBinding

  private var selectedCategoryId: String = "1"

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    showFragment(PopularFragment())
    listener()
  }

  private fun listener() {
    binding.toolbar.setOnMenuItemClickListener {
      when (it.itemId) {
        R.id.menu_favorite -> {
          Toast.makeText(this, "favorite clicked", Toast.LENGTH_SHORT).show()
        }
      }
      true
    }

    binding.buttonCategory.setOnClickListener {
      val categoryBottomSheet = CategoryBottomSheet { id ->
        when (id) {
          "1" -> showFragment(PopularFragment())
          "2" -> showFragment(UpcomingFragment())
          "3" -> showFragment(TopRatedFragment())
          "4" -> showFragment(NowPlayingFragment())
        }
      }

      val bundle = Bundle()
      bundle.putString(CategoryBottomSheet.ARGS_ID, selectedCategoryId)
      categoryBottomSheet.arguments = bundle
      categoryBottomSheet.show(supportFragmentManager, categoryBottomSheet.tag)
    }
  }

  private fun showFragment(fragment: Fragment) {
    val transaction = supportFragmentManager.beginTransaction()
    transaction.replace(R.id.container_fragment, fragment)
    transaction.addToBackStack(null)
    transaction.commit()
  }

}