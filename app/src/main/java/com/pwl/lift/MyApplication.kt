package com.pwl.lift

import android.app.Application
import com.pwl.lift.di.component.ApplicationComponent
import com.pwl.lift.di.component.DaggerApplicationComponent
import com.pwl.lift.di.module.DatabaseModule

/**
 * Created by ivet on 23/01/2018.
 */
class MyApplication : Application() {

	lateinit var applicationComponent: ApplicationComponent

	override fun onCreate() {
		super.onCreate()

		initApplicationComponent()
	}

	private fun initApplicationComponent() {
		applicationComponent = DaggerApplicationComponent.builder()
			.databaseModule(DatabaseModule(this))
			.build()
	}
}