package com.piotrprus.picsumgallery.feature.gallery.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.piotrprus.picsumgallery.data.model.Picsum
import com.piotrprus.picsumgallery.databinding.ItemPicsumBinding

private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Picsum>() {
    override fun areItemsTheSame(oldItem: Picsum, newItem: Picsum): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Picsum, newItem: Picsum): Boolean =
        oldItem == newItem
}

class PicsumAdapter(private val onCLickAction: (Picsum) -> Unit) :
    ListAdapter<Picsum, PicsumViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicsumViewHolder {
        val binding = ItemPicsumBinding.inflate(
            LayoutInflater.from(
                parent.context
            ),
            parent,
            false
        )
        return PicsumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PicsumViewHolder, position: Int) {
        val picsum = getItem(position)
        holder.itemView.setOnClickListener { onCLickAction(picsum) }
        holder.bind(picsum)
    }
}