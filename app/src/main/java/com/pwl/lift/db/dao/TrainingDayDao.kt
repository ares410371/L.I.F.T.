package com.pwl.lift.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.pwl.lift.db.entity.TrainingDay
import io.reactivex.Maybe
import java.util.Date

/**
 * Created by ivet on 23/01/2018.
 */

@Dao
interface TrainingDayDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertTrainingDay(trainingDay: TrainingDay)

	@Update
	fun updateTrainingDay(trainingDay: TrainingDay)

	@Delete
	fun deleteTrainingDay(trainingDay: TrainingDay)

	@Query("SELECT * FROM Training_day WHERE date = :arg0")
	fun getTrainingDayByDate(date: Date) : Maybe<TrainingDay>
}