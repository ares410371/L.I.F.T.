package com.ivet.lift.di.module

import android.arch.lifecycle.ViewModel
import com.ivet.lift.di.scope.AppScope
import com.ivet.lift.ui.viewModel.factory.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class ActivityModule() {

	@Provides
	@AppScope
	fun provideViewModelFactory(viewModels: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>): ViewModelFactory {
		return  ViewModelFactory(viewModels)
	}
}