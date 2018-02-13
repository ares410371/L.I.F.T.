package com.ivet.lift.ui.viewModel.factory

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.ivet.lift.di.scope.ActivityScope
import java.lang.Exception
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

class ViewModelFactory @Inject constructor (val viewModels: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) : ViewModelProvider.Factory, LifecycleObserver {

	override fun <T : ViewModel> create(modelClass: Class<T>): T {
		try {
			@Suppress("UNCHECKED_CAST")
			return viewModels[modelClass]?.get() as T
		} catch (ex: Exception) {
			throw RuntimeException("Error creating view model for class: " + modelClass.simpleName, ex)
		}
	}
}