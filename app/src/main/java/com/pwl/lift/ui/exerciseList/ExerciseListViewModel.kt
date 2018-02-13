package com.ivet.lift.ui.viewModel

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.support.v7.widget.SearchView
import android.util.Log
import com.ivet.lift.repository.TrainingDatabase
import com.ivet.lift.repository.dao.ExerciseDao
import com.ivet.lift.repository.data.Exercise
import com.ivet.lift.utils.RxSearchObservable
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import org.jetbrains.annotations.NotNull
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import android.databinding.adapters.NumberPickerBindingAdapter.setValue



/**
 * Created by ivet on 01/02/2018.
 */
class ExerciseListViewModel(val exerciseDao: ExerciseDao) : ViewModel(), LifecycleObserver {


	val result: LiveData<List<Exercise>>
	val query = MutableLiveData<String>()

	var searchQuery: String? = null

	init {
		result = Transformations.switchMap(query, {
			if (it == null || it.trim().isEmpty()) {
				getAllExercises()
			} else {
				getExerciseByName(it)
			}
		})
	}

	@OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
	fun initQuery() {
		setQuery(query.value ?: "")
		//setQuery("")
	}

	fun setQuery(@NotNull originalInput:String) {
		searchQuery = originalInput.toLowerCase().trim()
		if (searchQuery == query.value) {
			return
		}
		query.value = searchQuery
	}

	fun getQuery(): String? = query.value

	fun getAllExercises() = exerciseDao.getAllExercises()

	fun getExerciseByName(name: String) = exerciseDao.getExerciseByName("%" + name + "%")

	fun getSearchViewObservable(searchView: SearchView): Observable<String> {
		return RxSearchObservable.fromView(searchView)
			.debounce(300, TimeUnit.MILLISECONDS)
			.subscribeOn(Schedulers.io())
			.observeOn(AndroidSchedulers.mainThread())
	}

	fun deleteExercise(exercise: Exercise): Completable {
		return Completable.fromCallable {
			exerciseDao.deleteExercise(exercise)
		}.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
	}

}