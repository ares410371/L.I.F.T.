package com.pwl.lift.di.module

import android.arch.lifecycle.ViewModel
import com.pwl.lift.di.anotation.scope.AppScope
import com.pwl.lift.factory.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class ActivityModule() {

	@Provides
	@AppScope
	fun provideViewModelFactory(viewModels: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>): ViewModelFactory {
		return ViewModelFactory(viewModels)
	}
}