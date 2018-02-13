package com.pwl.lift.di.module

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.pwl.lift.common.Background
import com.pwl.lift.db.TrainingDatabase
import com.pwl.lift.db.dao.ExerciseDao
import com.pwl.lift.db.dao.TrainingDayDao
import com.pwl.lift.db.dao.WeightAndRepsDao
import com.pwl.lift.di.anotation.scope.AppScope
import com.pwl.lift.common.initExercises
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.experimental.launch

/**
 * Created by ivet on 23/01/2018.
 */

@Module
class DatabaseModule(val appContext: Context) {

	@Provides
	@AppScope
	fun provideTrainingDatabase(): TrainingDatabase {
		val trainingDatabase: TrainingDatabase = Room.databaseBuilder(appContext.applicationContext, TrainingDatabase::class.java, "TrainingDatabase.db")
			.addCallback(object : RoomDatabase.Callback() {
				override fun onCreate(db: SupportSQLiteDatabase) {
					super.onCreate(db)
					launch(Background) {
						initExercises(appContext, provideTrainingDatabase().exerciseDao())
					}
				}
			}).build()

		return trainingDatabase;
	}

	@Provides
	@AppScope
	fun provideTrainingDayDao(trainingDatabase: TrainingDatabase): TrainingDayDao = trainingDatabase.trainingDayDao()

	@Provides
	@AppScope
	fun provideExerciseDao(trainingDatabase: TrainingDatabase): ExerciseDao = trainingDatabase.exerciseDao()

	@Provides
	@AppScope
	fun provideWeightAndRepsDao(trainingDatabase: TrainingDatabase): WeightAndRepsDao = trainingDatabase.weightAndRepsDao()
}