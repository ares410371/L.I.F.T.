package com.ivet.lift.di.component

import com.ivet.lift.di.module.ActivityModule
import com.ivet.lift.di.scope.AppScope
import com.ivet.lift.ui.activity.AddExerciseActivity
import com.ivet.lift.ui.activity.ExerciseListActivity
import dagger.Subcomponent

@AppScope
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

	fun inject(exerciseListActivity: ExerciseListActivity)

	fun inject(addExerciseActivity: AddExerciseActivity)

	@Subcomponent.Builder
	interface Builder {
		fun activityModule(activityModule: ActivityModule): Builder
		fun build(): ActivityComponent
	}
}