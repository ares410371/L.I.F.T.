package com.ivet.lift.di.module

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.ivet.lift.di.scope.AppScope
import com.ivet.lift.repository.TrainingDatabase
import com.ivet.lift.repository.dao.ExerciseDao
import com.ivet.lift.repository.dao.TrainingDayDao
import com.ivet.lift.repository.dao.WeightAndRepsDao
import com.ivet.lift.repository.initExercises
import dagger.Module
import dagger.Provides

/**
 * Created by ivet on 23/01/2018.
 */

@Module
class DatabaseModule(val context: Context) {

	@Provides
	@AppScope
	fun provideTrainingDatabase(): TrainingDatabase {
		val trainingDatabase: TrainingDatabase = Room.databaseBuilder(context.applicationContext, TrainingDatabase::class.java, "TrainingDatabase.db")
			.addCallback(object : RoomDatabase.Callback() {
				override fun onCreate(db: SupportSQLiteDatabase) {
					super.onCreate(db)
					initExercises(context, provideTrainingDatabase().exerciseDao()).subscribe()
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