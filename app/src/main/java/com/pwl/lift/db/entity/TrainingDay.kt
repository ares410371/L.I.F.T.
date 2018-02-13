package com.pwl.lift.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.Date

/**
 * Created by ivet on 22/01/2018.
 */

@Entity(tableName = "Training_day")
data class TrainingDay(@PrimaryKey(autoGenerate = true) var id : Int, var date: Date) {
	constructor() : this(0, Date())
}