package com.piotrprus.picsumgallery.feature.gallery.recyclerview

import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.piotrprus.picsumgallery.R
import com.piotrprus.picsumgallery.data.model.Picsum
import com.piotrprus.picsumgallery.databinding.ItemPicsumBinding

class PicsumViewHolder(private val binding: ItemPicsumBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(picsum: Picsum) {
        binding.itemPicsumImage.load(picsum.downloadUrl) {
            placeholder(R.drawable.ic_placeholder)
            crossfade(true)
        }
    }
}