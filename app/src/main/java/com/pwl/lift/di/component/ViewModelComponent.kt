package com.ivet.lift.di.component

import android.arch.lifecycle.ViewModel
import com.ivet.lift.di.module.ViewModelModule
import com.ivet.lift.di.scope.ActivityScope
import com.ivet.lift.ui.activity.ExerciseListActivity
import com.ivet.lift.ui.viewModel.factory.ViewModelFactory
import dagger.Component
import javax.inject.Provider

@ActivityScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ViewModelModule::class))
interface ViewModelComponent {

	fun viewModelFactory(): ViewModelFactory

	fun activityComponentBuilder(): ActivityComponent.Builder

	fun viewModels(): Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>

	fun inject(exerciseListActivity: ExerciseListActivity)
}