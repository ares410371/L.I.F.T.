package com.pwl.lift.di.module

import android.arch.lifecycle.ViewModel
import com.pwl.lift.db.dao.ExerciseDao
import com.pwl.lift.di.anotation.ViewModelKey
import com.pwl.lift.di.anotation.scope.ActivityScope
import com.pwl.lift.di.component.ActivityComponent
import com.pwl.lift.ui.exerciseList.ExerciseListViewModel
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
}