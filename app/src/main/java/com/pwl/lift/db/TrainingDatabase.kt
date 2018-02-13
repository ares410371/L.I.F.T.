package com.pwl.lift.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.pwl.lift.db.dao.ExerciseDao
import com.pwl.lift.db.dao.TrainingDayDao
import com.pwl.lift.db.dao.WeightAndRepsDao
import com.pwl.lift.db.entity.Exercise
import com.pwl.lift.db.entity.TrainingDay
import com.pwl.lift.db.entity.WeightAndReps

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

