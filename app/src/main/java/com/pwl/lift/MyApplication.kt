package com.pwl.lift

import android.app.Activity
import android.app.Application
import com.pwl.lift.di.component.DaggerApplicationComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by ivet on 23/01/2018.
 */
class MyApplication : Application(), HasActivityInjector {

	@Inject
	lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

	override fun activityInjector(): DispatchingAndroidInjector<Activity> {
		return activityDispatchingAndroidInjector
	}

	override fun onCreate() {
		super.onCreate()

		DaggerApplicationComponent
			.builder()
			.application(this)
			.build()
			.inject(this)
	}
}