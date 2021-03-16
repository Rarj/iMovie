package rio.arj.imovie.features.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import rio.arj.imovie.R
import rio.arj.imovie.databinding.BottomSheetCategoryBinding

class CategoryBottomSheet : BottomSheetDialogFragment() {

  lateinit var binding: BottomSheetCategoryBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {

    binding = DataBindingUtil.inflate(inflater, R.layout.bottom_sheet_category, container, false)

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    listener()
  }

  private fun listener() {
    binding.buttonClose.setOnClickListener {
      dismiss()
    }
  }

}