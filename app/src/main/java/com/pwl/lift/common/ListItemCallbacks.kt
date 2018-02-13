package com.pwl.lift.common

interface ClickCallback<in T> {
	fun onItemClick(item: T)
	fun onItemLongClick(item: T)
}