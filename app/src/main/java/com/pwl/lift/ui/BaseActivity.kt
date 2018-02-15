package com.pwl.lift.ui

import android.arch.lifecycle.ViewModel
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection

abstract class BaseActivity<V : ViewModel> : AppCompatActivity() {

	protected val TAG = this.javaClass.simpleName

	lateinit var viewModel: V

	abstract fun initViewModel()
	abstract fun initViewDataBinding()

	override fun onCreate(savedInstanceState: Bundle?) {
		AndroidInjection.inject(this)
		super.onCreate(savedInstanceState)

		initViewModel()
		initViewDataBinding()
	}
}