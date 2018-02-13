package com.ivet.lift.di.module

import android.arch.lifecycle.ViewModel
import com.ivet.lift.di.component.ActivityComponent
import com.ivet.lift.di.key.ViewModelKey
import com.ivet.lift.di.scope.ActivityScope
import com.ivet.lift.repository.dao.ExerciseDao
import com.ivet.lift.ui.viewModel.AddExerciseViewModel
import com.ivet.lift.ui.viewModel.ExerciseListViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(subcomponents = arrayOf(ActivityComponent::class))
class ViewModelModule {

	@Provides
	@IntoMap
	@ActivityScope
	@ViewModelKey(ExerciseListViewModel::class)
	fun provideExerciseListViewModel(exerciseDao: ExerciseDao): ViewModel {
		return ExerciseListViewModel(exerciseDao)
	}

	@Provides
	@IntoMap
	@ActivityScope
	@ViewModelKey(AddExerciseViewModel::class)
	fun provideAddExerciseViewModel(exerciseDao: ExerciseDao): ViewModel {
		return AddExerciseViewModel(exerciseDao)
	}
}