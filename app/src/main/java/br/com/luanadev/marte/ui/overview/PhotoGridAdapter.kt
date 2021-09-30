package br.com.luanadev.marte.ui.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.luanadev.marte.databinding.GridViewItemBinding
import br.com.luanadev.marte.database.MarsPropertyEntities

class PhotoGridAdapter( private val onClickListener: OnClickListener ) :
    ListAdapter<MarsPropertyEntities,
            PhotoGridAdapter.MarsPropertyViewHolder>(DiffCallback) {

    class MarsPropertyViewHolder(private var binding: GridViewItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(marsProperty: MarsPropertyEntities) {
            binding.property = marsProperty
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MarsPropertyEntities>() {
        override fun areItemsTheSame(oldItem: MarsPropertyEntities, newItem: MarsPropertyEntities): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MarsPropertyEntities, newItem: MarsPropertyEntities): Boolean {
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

    class OnClickListener(val clickListener: (marsProperty: MarsPropertyEntities) -> Unit) {
        fun onClick(marsProperty: MarsPropertyEntities) = clickListener(marsProperty)
    }
}

