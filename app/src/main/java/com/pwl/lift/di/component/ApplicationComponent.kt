package com.ivet.lift.di.component

import com.ivet.lift.di.module.ApplicationModule
import com.ivet.lift.di.module.DatabaseModule
import com.ivet.lift.di.scope.AppScope
import com.ivet.lift.repository.dao.ExerciseDao
import dagger.Component

/**
 * Created by ivet on 23/01/2018.
 */

@AppScope
@Component(modules = arrayOf(ApplicationModule::class, DatabaseModule::class))
interface ApplicationComponent {

	fun getExerciseDao(): ExerciseDao
}