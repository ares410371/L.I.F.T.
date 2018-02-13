package com.pwl.lift.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.pwl.lift.db.entity.WeightAndReps
import io.reactivex.Flowable

/**
 * Created by ivet on 23/01/2018.
 */

@Dao
interface WeightAndRepsDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertWeightAndReps(weightAndReps: WeightAndReps)

	@Update
	fun updateWeightAndReps(weightAndReps: WeightAndReps)

	@Delete
	fun deleteWeightAndReps(weightAndReps: WeightAndReps)

	@Query("SELECT * from Weight_and_reps WHERE exercise_id = :arg0")
	fun getWeightAndRepsByExercise(id: String): Flowable<List<WeightAndReps>>
}