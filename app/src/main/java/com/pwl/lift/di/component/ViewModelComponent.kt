package com.pwl.lift.di.component

import android.arch.lifecycle.ViewModel
import com.pwl.lift.di.anotation.scope.ActivityScope
import com.pwl.lift.di.module.ViewModelModule
import com.pwl.lift.factory.ViewModelFactory
import com.pwl.lift.ui.exerciseList.ExerciseListActivity
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