package com.pwl.lift.ui.exerciseList

import com.pwl.lift.di.anotation.scope.ActivityScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent(modules = arrayOf(ExerciseListModule::class))
interface ExerciseListComponent: AndroidInjector<ExerciseListActivity> {

	@Subcomponent.Builder
	abstract class Builder: AndroidInjector.Builder<ExerciseListActivity>()
}