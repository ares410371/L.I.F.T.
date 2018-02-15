package com.pwl.lift.di.component

import android.app.Application
import com.pwl.lift.MyApplication
import com.pwl.lift.di.anotation.scope.AppScope
import com.pwl.lift.di.module.ApplicationModule
import com.pwl.lift.di.module.DatabaseModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

/**
 * Created by ivet on 23/01/2018.
 */

@AppScope
@Component(modules = arrayOf(AndroidInjectionModule::class, ApplicationModule::class, DatabaseModule::class, ActivityBuilder::class))
interface ApplicationComponent {

	fun inject(myApplication: MyApplication)

	@Component.Builder
	interface Builder {
		@BindsInstance
		fun application(application: Application): Builder
		fun build(): ApplicationComponent
	}
}