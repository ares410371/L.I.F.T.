package com.pwl.lift.di.component

import android.app.Activity
import com.pwl.lift.ui.exerciseList.ExerciseListActivity
import com.pwl.lift.ui.exerciseList.ExerciseListComponent
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ActivityBuilder {

	@Binds
	@IntoMap
	@ActivityKey(ExerciseListActivity::class)
	abstract fun bindExerciseListActivity(builder: ExerciseListComponent.Builder): AndroidInjector.Factory<out Activity>
}