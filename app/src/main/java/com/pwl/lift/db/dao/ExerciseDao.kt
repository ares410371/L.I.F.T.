package com.pwl.lift.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.pwl.lift.db.entity.Exercise

/**
 * Created by ivet on 23/01/2018.
 */

@Dao
interface ExerciseDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertExercise(exercise: Exercise)

	@Update
	fun updateExercise(exercise: Exercise)

	@Delete
	fun deleteExercise(exercise: Exercise)

	@Query("SELECT * FROM Exercise WHERE training_day_id = :arg0")
	fun getExercisesByTrainingDay(id: String): LiveData<List<Exercise>>

	@Query("SELECT * FROM Exercise WHERE name LIKE :arg0")
	fun getExerciseByName(name: String): LiveData<List<Exercise>>

	@Query("SELECT * FROM Exercise ORDER BY name")
	fun getAllExercises(): LiveData<List<Exercise>>
}