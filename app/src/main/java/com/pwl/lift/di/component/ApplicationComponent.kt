package com.pwl.lift.di.component

import com.pwl.lift.db.dao.ExerciseDao
import com.pwl.lift.di.anotation.scope.AppScope
import com.pwl.lift.di.module.ApplicationModule
import com.pwl.lift.di.module.DatabaseModule
import dagger.Component

/**
 * Created by ivet on 23/01/2018.
 */

@AppScope
@Component(modules = arrayOf(ApplicationModule::class, DatabaseModule::class))
interface ApplicationComponent {

	fun getExerciseDao(): ExerciseDao
}