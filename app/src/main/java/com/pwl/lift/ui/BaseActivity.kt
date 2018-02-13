package com.ivet.lift.ui.activity

import android.arch.lifecycle.ViewModel
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.ivet.lift.MyApplication
import com.ivet.lift.di.component.ActivityComponent
import com.ivet.lift.di.component.DaggerViewModelComponent
import com.ivet.lift.di.module.ActivityModule
import com.ivet.lift.di.module.ViewModelModule
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity<V : ViewModel> : AppCompatActivity() {

	protected val TAG = this.javaClass.simpleName

	protected lateinit var activityComponent: ActivityComponent

	protected val compositeDisposable: CompositeDisposable = CompositeDisposable()

	lateinit var viewModel: V

	abstract fun initInjector()
	abstract fun initViewModel()
	abstract fun initViewDataBinding()
	abstract fun getToolbar(): Toolbar
	abstract fun initViews()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		initActivityComponent()
		initInjector()
		initViewModel()
		initViewDataBinding()
		initActionBar(getToolbar())
		initViews()
	}

	override fun onDestroy() {
		super.onDestroy()

		if (!compositeDisposable.isDisposed) {
			compositeDisposable.dispose()
		}
	}

	protected fun initActionBar(toolbar: Toolbar) {
		setSupportActionBar(toolbar)
		val actionBar = supportActionBar

		if (actionBar != null) {
			initActionBarButton(actionBar);
		}
	}

	protected fun initActionBarButton(actionBar: ActionBar) {
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setDisplayHomeAsUpEnabled(true)
		actionBar.setHomeButtonEnabled(true)
	}

	private fun initActivityComponent() {
		activityComponent = DaggerViewModelComponent.builder()
			.applicationComponent((application as MyApplication).applicationComponent)
			.viewModelModule(ViewModelModule())
			.build()
			.activityComponentBuilder().activityModule(ActivityModule()).build()
	}
}