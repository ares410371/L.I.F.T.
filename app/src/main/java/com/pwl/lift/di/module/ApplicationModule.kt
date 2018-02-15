package com.pwl.lift.di.module

import com.pwl.lift.ui.exerciseList.ExerciseListComponent
import dagger.Module

@Module(subcomponents = arrayOf(ExerciseListComponent::class))
class ApplicationModule() {
}

