package com.pwl.lift.di.component

import com.pwl.lift.di.anotation.scope.AppScope
import com.pwl.lift.di.module.ActivityModule
import com.pwl.lift.ui.exerciseList.ExerciseListActivity
import dagger.Subcomponent

@AppScope
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

	fun inject(exerciseListActivity: ExerciseListActivity)

	@Subcomponent.Builder
	interface Builder {
		fun activityModule(activityModule: ActivityModule): Builder
		fun build(): ActivityComponent
	}
}