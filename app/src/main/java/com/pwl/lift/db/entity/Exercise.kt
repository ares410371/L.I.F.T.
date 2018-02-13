package com.pwl.lift.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.ForeignKey.CASCADE
import android.arch.persistence.room.PrimaryKey

/**
 * Created by ivet on 22/01/2018.
 */

@Entity(tableName = "Exercise", foreignKeys = arrayOf(ForeignKey(entity = TrainingDay::class,
	    parentColumns = arrayOf("id"),
	    childColumns = arrayOf("training_day_id"),
	    onDelete = CASCADE)))
data class Exercise(@PrimaryKey(autoGenerate = true) var id: Int,
	                var name: String,
	                var iconId: Int,
	                @ColumnInfo(name = "training_day_id") var trainingDayId: String?) {
	constructor() : this(0, "", -1, "")
}
