package com.ivet.lift.repository

import android.arch.persistence.room.TypeConverter
import java.util.Date

/**
 * Created by ivet on 01/02/2018.
 */

class Converters {

	@TypeConverter
	fun fromTimestamp(value: Long?): Date? {
		return if (value == null) null else Date(value)
	}

	@TypeConverter
	fun dateToTimestamp(date: Date?): Long? {
		return date?.time
	}
}