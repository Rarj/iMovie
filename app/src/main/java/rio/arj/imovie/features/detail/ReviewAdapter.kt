package rio.arj.imovie.features.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import rio.arj.imovie.BR
import rio.arj.imovie.databinding.ItemReviewBinding
import rio.arj.imovie.repository.review.model.Result

class ReviewAdapter : PagedListAdapter<Result, ReviewAdapter.ViewHolder>(diffCallback) {

  companion object {
    val diffCallback = object : DiffUtil.ItemCallback<Result>() {
      override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem.id == newItem.id
      }

      override fun areContentsTheSame(
        oldItem: Result,
        newItem: Result
      ): Boolean {
        return oldItem == newItem
      }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val viewDataBinding = ItemReviewBinding.inflate(inflater, parent, false)
    return ViewHolder(viewDataBinding)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(getItem(position))
  }

  class ViewHolder(private val viewDataBinding: ViewDataBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root) {
    fun bind(model: Result?) {
      viewDataBinding.setVariable(BR.reviewResult, model)
      viewDataBinding.executePendingBindings()
    }
  }

}