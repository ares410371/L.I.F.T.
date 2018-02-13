package com.pwl.lift.ui.exerciseList

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.pwl.lift.BR
import com.pwl.lift.R
import com.pwl.lift.common.ClickCallback
import com.pwl.lift.common.DiffObservableListLiveData
import com.pwl.lift.common.EventLiveData
import com.pwl.lift.db.dao.ExerciseDao
import com.pwl.lift.db.entity.Exercise
import me.tatarka.bindingcollectionadapter2.ItemBinding
import me.tatarka.bindingcollectionadapter2.collections.DiffObservableList

/**
 * Created by ivet on 01/02/2018.
 */
class ExerciseListViewModel(val exerciseDao: ExerciseDao) : ViewModel(), ClickCallback<ExerciseItemViewModel> {

	var exercises: DiffObservableListLiveData<ExerciseItemViewModel>
	val itemBinding = ItemBinding.of<ExerciseItemViewModel>(BR.itemViewModel, R.layout.exercise_item).bindExtra(BR.viewModel, this)!!

	var query = MutableLiveData<String>().apply {
		value = ""
	}

	val actionModeAction = EventLiveData<MutableList<ExerciseItemViewModel>>()

	init {
		exercises = DiffObservableListLiveData(getData(), object : DiffObservableList.Callback<ExerciseItemViewModel> {
			override fun areItemsTheSame(oldItem: ExerciseItemViewModel?, newItem: ExerciseItemViewModel?): Boolean = oldItem?.exercise == newItem?.exercise
			override fun areContentsTheSame(oldItem: ExerciseItemViewModel?, newItem: ExerciseItemViewModel?): Boolean = oldItem?.exercise == newItem?.exercise
		})
	}

	override fun onItemClick(item: ExerciseItemViewModel) {
		val value = actionModeAction.value
		value?.remove(item)

		actionModeAction.value = value
	}

	override fun onItemLongClick(item: ExerciseItemViewModel) {
		if (actionModeAction.value == null) {
			actionModeAction.value = arrayListOf(item)
		} else {
			val value = actionModeAction.value
			value?.add(item)

			actionModeAction.value = value
		}
	}

	fun setActionMode(list: List<ExerciseItemViewModel>) {
		actionModeAction.value = list.toMutableList()
	}

	fun deleteSelectedExercises() {
		actionModeAction.value?.forEach {
			exerciseDao.deleteExercise(it.exercise)
		}
	}

	fun refresh() {
		actionModeAction.value = actionModeAction.value
		query.value = query.value
	}

	private fun getData() = Transformations.switchMap(query, {
		if (it.isNullOrBlank()) {
			getAllExercises()
		} else {
			getExercisesByName(it)
		}
	})

	private fun getAllExercises(): LiveData<List<ExerciseItemViewModel>> = Transformations.map(exerciseDao.getAllExercises(), {
		it.map {
			ExerciseItemViewModel(it, this)
		}
	})

	private fun getExercisesByName(string: String) = Transformations.map(exerciseDao.getExerciseByName("%$string%"), {
		it.map {
			ExerciseItemViewModel(it, this)
		}
	})
}

class ExerciseItemViewModel(val exercise: Exercise, val callback: ClickCallback<ExerciseItemViewModel>) {

	var isSelected = MutableLiveData<Boolean>().apply {
		value = false
	}

	fun onItemLongClick(): Boolean {
		isSelected.value = !(isSelected.value)!!
		callback.onItemLongClick(this)

		return true
	}

	fun onItemClick() {
		if (isSelected.value!!) {
			isSelected.value = !(isSelected.value)!!
			callback.onItemClick(this)
		}
	}
}