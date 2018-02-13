package com.pwl.lift.ui

import android.arch.lifecycle.ViewModel
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pwl.lift.MyApplication
import com.pwl.lift.di.component.ActivityComponent
import com.pwl.lift.di.component.DaggerViewModelComponent
import com.pwl.lift.di.module.ActivityModule
import com.pwl.lift.di.module.ViewModelModule

abstract class BaseActivity<V : ViewModel> : AppCompatActivity() {

	protected val TAG = this.javaClass.simpleName

	protected lateinit var activityComponent: ActivityComponent

	lateinit var viewModel: V

	abstract fun initInjector()
	abstract fun initViewModel()
	abstract fun initViewDataBinding()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		initActivityComponent()
		initInjector()
		initViewModel()
		initViewDataBinding()
	}

	private fun initActivityComponent() {
		activityComponent = DaggerViewModelComponent.builder()
			.applicationComponent((application as MyApplication).applicationComponent)
			.viewModelModule(ViewModelModule())
			.build()
			.activityComponentBuilder().activityModule(ActivityModule()).build()
	}
}