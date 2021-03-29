package com.example.filminfo.ui.widgets

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.example.filminfo.R
import com.example.filminfo.extentions.fetchColor
import com.example.filminfo.extentions.invisible
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.view_toolbar.view.*

class MainToolbar : AppBarLayout {

    init {
        inflate(context, R.layout.view_toolbar, this)
    }

    var title = ""
        set(value) {
            field = value
            toolbar_title?.text = value
        }

    var bgColor = 0
        set(value) {
            field = value
            setBackgroundColor(value)
        }

    //region Init

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    private fun init(attrs: AttributeSet) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.MainToolbar, 0, 0)
        try {
            title = ta.getString(R.styleable.MainToolbar_mt_title) ?: ""
            bgColor = ta.getInt(R.styleable.MainToolbar_mt_background, 0)
        } finally {
            ta.recycle()
        }
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        setBackgroundColor(bgColor)
        toolbar_title?.text = title
    }

    //endregion

    fun bind(
        leftActionButton: ActionInfo? = null,
        rightActionButton: ActionInfo? = null,
        layout: LayoutInfo? = null
    ) {
        toolbar_left_action?.invisible = leftActionButton == null
        leftActionButton?.let {
            toolbar_left_action?.setImageDrawable(getDrawable(it.iconRes))
            if (it.iconTint != 0) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    toolbar_left_action?.imageTintList =
                        ColorStateList.valueOf(context.fetchColor(it.iconTint))
                }
            }
            toolbar_left_action?.setOnClickListener { leftActionButton.onClick() }
        }

        layout?.let {
            if (it.backgroundColor != 0) {
                this.setBackgroundColor(context.fetchColor(it.backgroundColor))
                app_bar_layout.setBackgroundColor(context.fetchColor(it.backgroundColor))
            }

            if (it.title != 0) {
                toolbar_title?.text = context.getString(it.title)
            }
        }
    }

    fun setTitle(@StringRes stringRes: Int) {
        title = context.getString(stringRes)
    }

    private fun getDrawable(iconRes: Int): Drawable? {
        val autoMirrored = ContextCompat.getDrawable(context, iconRes)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            autoMirrored?.isAutoMirrored = true
        }
        return autoMirrored
    }

    data class ActionInfo(
        @DrawableRes val iconRes: Int = 0,
        @ColorRes val iconTint: Int = 0,
        val onClick: () -> Unit
    )

    data class LayoutInfo(
        @ColorRes val backgroundColor: Int = 0,
        @StringRes val title: Int = 0
    )
}
