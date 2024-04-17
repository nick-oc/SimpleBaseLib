package org.nick.master.library.adapter

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.nick.master.library.utils.dp

class GridDivider(
    private var space: Int = 12.dp,
    spaceColor: Int = Color.TRANSPARENT
) : RecyclerView.ItemDecoration() {
    private var mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        mPaint.color = spaceColor
        mPaint.style = Paint.Style.FILL
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val lm = parent.layoutManager
        if (lm is GridLayoutManager) {
            val spanCount = lm.spanCount
            val position = parent.getChildAdapterPosition(view)
            val column = position % spanCount
            if (position >= spanCount) {
                outRect.top = space
            }
            outRect.left = space * column / spanCount
            outRect.right = space - (column + 1) * space / spanCount
        } else if (lm is LinearLayoutManager) {
            if (lm.orientation == LinearLayoutManager.VERTICAL) {
                outRect.bottom = space
            } else {
                outRect.right = space
            }
        }
    }
}