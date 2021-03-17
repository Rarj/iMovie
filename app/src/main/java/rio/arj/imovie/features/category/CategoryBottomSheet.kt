package rio.arj.imovie.features.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import rio.arj.imovie.R
import rio.arj.imovie.databinding.BottomSheetCategoryBinding
import rio.arj.imovie.repository.category.model.CategoryResponse

class CategoryBottomSheet(
  private val onCategorySelected: (id: String) -> Unit
) : BottomSheetDialogFragment() {

  lateinit var viewModel: CategoryViewModel
  lateinit var binding: BottomSheetCategoryBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {

    viewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)
    binding = DataBindingUtil.inflate(inflater, R.layout.bottom_sheet_category, container, false)
    binding.viewModel = viewModel
    binding.lifecycleOwner = this

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setExpanded(view)

    viewModel.getCategoryList()
    listener()
    observer()
  }

  private fun listener() {
    binding.buttonClose.setOnClickListener {
      dismiss()
    }
  }

  private fun observer() {
    viewModel.listCategory.observe(this, {
      if (it.isNotEmpty()) {
        setAdapter(it)
      }
    })
  }

  private fun setAdapter(list: List<CategoryResponse>) {
    val selectedId = arguments?.getString(ARGS_ID) ?: throw RuntimeException("Id must not null")
    val categoryAdapter = CategoryAdapter(list, selectedId) { id ->
      onCategorySelected(id)
      dismiss()
    }
    binding.recyclerCategory.apply {
      layoutManager = LinearLayoutManager(requireActivity())
      adapter = categoryAdapter
    }
  }

  private fun setExpanded(view: View) {
    view.viewTreeObserver.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
      override fun onGlobalLayout() {
        val bottomSheet =
          (dialog as BottomSheetDialog).findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
        BottomSheetBehavior.from<View>(bottomSheet!!).apply {
          state = BottomSheetBehavior.STATE_EXPANDED
          peekHeight = 0
        }
        view.viewTreeObserver.removeOnGlobalLayoutListener(this)
      }
    })
  }

  companion object {
    const val ARGS_ID = "ID"
  }

}