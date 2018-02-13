package com.ivet.lift

import android.app.Application
import com.ivet.lift.di.component.ApplicationComponent
import com.ivet.lift.di.component.DaggerApplicationComponent
import com.ivet.lift.di.module.ApplicationModule
import com.ivet.lift.di.module.DatabaseModule
import com.ivet.lift.ui.viewModel.factory.ViewModelFactory
import javax.inject.Inject

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