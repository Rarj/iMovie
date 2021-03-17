package rio.arj.imovie.features.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import rio.arj.imovie.BR
import rio.arj.imovie.databinding.ItemMovieBinding
import rio.arj.imovie.repository.list.model.Result

class MainAdapter(
  private val onMovieClicked: (movieId: Int) -> Unit
) : PagedListAdapter<Result, MainAdapter.ViewHolder>(diffCallback) {

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
    val viewDataBinding = ItemMovieBinding.inflate(inflater, parent, false)
    return ViewHolder(viewDataBinding)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(getItem(position), onMovieClicked)
  }

  class ViewHolder(private val viewDataBinding: ViewDataBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root) {
    fun bind(
      model: Result?,
      onMovieClicked: (movieId: Int) -> Unit
    ) {
      viewDataBinding.setVariable(BR.movieResult, model)
      viewDataBinding.executePendingBindings()

      viewDataBinding.root.setOnClickListener {
        onMovieClicked(
          model?.id ?: throw RuntimeException("movie id must not null")
        )
      }
    }
  }

}