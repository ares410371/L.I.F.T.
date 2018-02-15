package com.pwl.lift.ui.exerciseList

import android.arch.lifecycle.ViewModel
import com.pwl.lift.db.dao.ExerciseDao
import com.pwl.lift.di.anotation.ViewModelKey
import com.pwl.lift.di.anotation.scope.ActivityScope
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class ExerciseListModule {

	@Provides
	@IntoMap
	@ActivityScope
	@ViewModelKey(ExerciseListViewModel::class)
	fun provideExerciseListViewModel(exerciseDao: ExerciseDao): ViewModel {
		return ExerciseListViewModel(exerciseDao)
	}
}