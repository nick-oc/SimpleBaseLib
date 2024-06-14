package org.nick.master.library.adapter

import android.graphics.Canvas
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
    spaceColor: Int = Color.TRANSPARENT,
) : RecyclerView.ItemDecoration() {
    private var mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        mPaint.color = spaceColor
        mPaint.style = Paint.Style.FILL
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        val lm = parent.layoutManager as LinearLayoutManager
        val childCount = parent.childCount
        var child: View
        var rect: Rect
        var left: Int
        var top: Int
        var right: Int
        var bottom: Int
        for (i in 0 until childCount) {
            child = parent.getChildAt(i)
            left = lm.getLeftDecorationWidth(child)
            top = lm.getTopDecorationHeight(child)
            right = lm.getRightDecorationWidth(child)
            bottom = lm.getBottomDecorationHeight(child)
            if (left > 0) {
                rect = Rect()
                rect.left = child.left - left
                rect.right = child.left
                rect.top = child.top - top
                rect.bottom = child.bottom + bottom
                c.drawRect(rect, mPaint)
            }
            if (top > 0) {
                rect = Rect()
                rect.left = child.left - left
                rect.right = child.right + right
                rect.top = child.top - top
                rect.bottom = child.top
                c.drawRect(rect, mPaint)
            }
            if (right > 0) {
                rect = Rect()
                rect.left = child.right
                rect.right = child.right + right
                rect.top = child.top - top
                rect.bottom = child.bottom + bottom
                c.drawRect(rect, mPaint)
            }
            if (bottom > 0) {
                rect = Rect()
                rect.left = child.left - left
                rect.right = child.right + right
                rect.top = child.bottom
                rect.bottom = child.bottom + bottom
                c.drawRect(rect, mPaint)
            }
        }
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State,
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val lm = parent.layoutManager
        val position = parent.getChildAdapterPosition(view)
        if (lm is GridLayoutManager) {
            val spanCount = lm.spanCount
            val column = position % spanCount

            if (lm.orientation == RecyclerView.VERTICAL) {
                // 垂直
                if (position >= spanCount) {
                    outRect.top = space
                }
                outRect.left = space * column / spanCount
                outRect.right = space - (column + 1) * space / spanCount
            } else {
                // 水平
                if (position >= spanCount) {
                    outRect.left = space
                }
                outRect.top = space * column / spanCount
                outRect.bottom = space - (column + 1) * space / spanCount
            }
        } else if (lm is LinearLayoutManager) {
            if (position == 0) return

            if (lm.orientation == RecyclerView.VERTICAL) {
                outRect.top = space
            } else {
                outRect.left = space
            }
        }
    }
}