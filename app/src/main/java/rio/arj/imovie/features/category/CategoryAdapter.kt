package rio.arj.imovie.features.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import rio.arj.imovie.BR
import rio.arj.imovie.R
import rio.arj.imovie.databinding.ItemCategoryBinding
import rio.arj.imovie.repository.category.model.CategoryResponse

class CategoryAdapter(
  private val categoryList: List<CategoryResponse>,
  private val id: String,
  private val onCategoryClicked: (id: String) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val viewDataBinding = ItemCategoryBinding.inflate(inflater, parent, false)
    return ViewHolder(viewDataBinding)
  }

  override fun getItemCount(): Int {
    return categoryList.size
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(categoryList[position], id, onCategoryClicked)
  }

  class ViewHolder(private val viewDataBinding: ItemCategoryBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root) {
    fun bind(
      model: CategoryResponse,
      id: String,
      onCategoryClicked: (id: String) -> Unit
    ) {
      viewDataBinding.setVariable(BR.categoryModel, model)
      viewDataBinding.executePendingBindings()

      if (id == model.id) {
        viewDataBinding.textCategoryName.setCompoundDrawablesWithIntrinsicBounds(
          0,
          0,
          R.drawable.ic_selected,
          0
        )
      }

      viewDataBinding.root.setOnClickListener {
        onCategoryClicked(model.id)
      }
    }
  }

}