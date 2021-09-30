package br.com.luanadev.marte.ui.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.luanadev.marte.databinding.MarsPropertyItemBinding
import br.com.luanadev.marte.network.MarsProperty

class OverviewAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<MarsProperty,
            OverviewAdapter.OverviewViewHolder>(DiffCallback) {

    class OverviewViewHolder(private var binding: MarsPropertyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(marsPropertyProperty: MarsProperty) {
            binding.property = marsPropertyProperty
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MarsProperty>() {
        override fun areItemsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OverviewViewHolder {
        return OverviewViewHolder(MarsPropertyItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: OverviewViewHolder, position: Int) {
        val marsProperty = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(marsProperty)
        }
        holder.bind(marsProperty)
    }

    class OnClickListener(val clickListener: (marsPropertyProperty: MarsProperty) -> Unit) {
        fun onClick(marsPropertyProperty: MarsProperty) = clickListener(marsPropertyProperty)
    }
}

