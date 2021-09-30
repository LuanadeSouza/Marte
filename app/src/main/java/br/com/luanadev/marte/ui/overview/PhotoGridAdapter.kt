package br.com.luanadev.marte.ui.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.luanadev.marte.databinding.GridViewItemBinding
import br.com.luanadev.marte.database.MarsEntities

class PhotoGridAdapter( private val onClickListener: OnClickListener ) :
    ListAdapter<MarsEntities,
            PhotoGridAdapter.MarsPropertyViewHolder>(DiffCallback) {

    class MarsPropertyViewHolder(private var binding: GridViewItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(mars: MarsEntities) {
            binding.property = mars
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MarsEntities>() {
        override fun areItemsTheSame(oldItem: MarsEntities, newItem: MarsEntities): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MarsEntities, newItem: MarsEntities): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MarsPropertyViewHolder {
        return MarsPropertyViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MarsPropertyViewHolder, position: Int) {
        val marsProperty = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(marsProperty)
        }
        holder.bind(marsProperty)
    }

    class OnClickListener(val clickListener: (mars: MarsEntities) -> Unit) {
        fun onClick(mars: MarsEntities) = clickListener(mars)
    }
}

