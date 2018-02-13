package com.ivet.lift.repository

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.ivet.lift.repository.dao.ExerciseDao
import com.ivet.lift.repository.dao.TrainingDayDao
import com.ivet.lift.repository.dao.WeightAndRepsDao
import com.ivet.lift.repository.data.Exercise
import com.ivet.lift.repository.data.TrainingDay
import com.ivet.lift.repository.data.WeightAndReps

/**
 * Created by ivet on 23/01/2018.
 */

@Database(entities = arrayOf(TrainingDay::class, Exercise::class, WeightAndReps::class), version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class TrainingDatabase : RoomDatabase() {

	abstract fun trainingDayDao(): TrainingDayDao
	abstract fun exerciseDao(): ExerciseDao
	abstract fun weightAndRepsDao(): WeightAndRepsDao
}

