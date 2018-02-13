package com.pwl.lift.common

import android.databinding.BindingAdapter
import android.graphics.Color
import android.support.constraint.ConstraintLayout
import android.widget.ImageView

@BindingAdapter("imageResource")
fun setImage(imageView: ImageView, res: Int) {
	imageView.setImageResource(res)
}

@BindingAdapter("backgroundColor")
fun setBackgroundColor(layout: ConstraintLayout, selected: Boolean) {
	if (selected) {
		layout.setBackgroundColor(Color.GRAY)
	} else {
		layout.setBackgroundColor(Color.TRANSPARENT)
	}
}




