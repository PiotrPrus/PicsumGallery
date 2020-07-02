package com.piotrprus.picsumgallery.feature.gallery.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.piotrprus.picsumgallery.R

class PicsumItemDecoration: RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val space = parent.context.resources.getDimensionPixelSize(R.dimen.picsum_item_space_decoration)
        val position = parent.getChildAdapterPosition(view)
        val column = position % 2

        outRect.left = space.minus(column.times(space.div(2)))
        outRect.right = (column.plus(1)).times(space.div(2))
        if (position < 2) {
            outRect.top = space
        }
        outRect.bottom = space
    }
}