package rio.arj.imovie.features.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import rio.arj.imovie.BR
import rio.arj.imovie.databinding.ItemFavoriteBinding
import rio.arj.imovie.repository.favorite.entity.DetailMovieEntity

class FavoriteAdapter(
  private val favoriteList: List<DetailMovieEntity>,
  private val onMovieClicked: (movieId: Int) -> Unit
) : RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val viewDataBinding = ItemFavoriteBinding.inflate(inflater, parent, false)
    return ViewHolder(viewDataBinding)
  }

  override fun getItemCount(): Int {
    return favoriteList.size
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(favoriteList[position], onMovieClicked)
  }

  class ViewHolder(private val viewDataBinding: ItemFavoriteBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root) {
    fun bind(
      model: DetailMovieEntity,
      onMovieClicked: (movieId: Int) -> Unit
    ) {
      viewDataBinding.setVariable(BR.movieResult, model)
      viewDataBinding.executePendingBindings()

      viewDataBinding.root.setOnClickListener {
        onMovieClicked(model.id)
      }
    }
  }

}