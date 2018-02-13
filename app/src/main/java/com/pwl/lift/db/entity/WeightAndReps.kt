package com.pwl.lift.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import java.util.UUID

/**
 * Created by ivet on 22/01/2018.
 */

@Entity(tableName = "Weight_and_reps", foreignKeys = arrayOf(ForeignKey(entity = Exercise::class,
														   parentColumns = arrayOf("id"),
													       childColumns = arrayOf("exercise_id"))))
data class WeightAndReps(@PrimaryKey var id : String,
						 var weight : Double,
	                     var reps : Int,
						 @ColumnInfo(name = "exercise_id") var exerciseId : String) {
	constructor() : this(UUID.randomUUID().toString(), 0.0, 0, "")
}