package com.pwl.lift.ui.exerciseList

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.view.ActionMode
import android.view.View
import com.pwl.lift.R
import com.pwl.lift.common.LifecycleAwareBindingRecyclerViewAdapter
import com.pwl.lift.common.ToolbarActionMode
import com.pwl.lift.common.load
import com.pwl.lift.common.then
import com.pwl.lift.databinding.ActivityExerciseListBinding
import com.pwl.lift.factory.ViewModelFactory
import com.pwl.lift.ui.BaseActivity
import javax.inject.Inject

interface ExerciseListView {
	fun onAddButtonClick(view: View)

	val lifecycleAwareAdapter: LifecycleAwareBindingRecyclerViewAdapter<ExerciseItemViewModel>
}

class ExerciseListActivity : BaseActivity<ExerciseListViewModel>(), ExerciseListView {

	override val lifecycleAwareAdapter: LifecycleAwareBindingRecyclerViewAdapter<ExerciseItemViewModel> = LifecycleAwareBindingRecyclerViewAdapter(this)

	@Inject
	lateinit var viewModelFactory: ViewModelFactory

	private val toolbarActionMode: ToolbarActionMode = ToolbarActionMode()
	private var actionMode: ActionMode? = null

	override fun initInjector() {
		activityComponent.inject(this)
	}

	override fun initViewModel() {
		viewModel = ViewModelProviders.of(this, viewModelFactory).get(ExerciseListViewModel::class.java)
		viewModel.actionModeAction.observe(this, Observer {
			it?.let { list -> onListItemSelected(list) }
		})
		toolbarActionMode.event.observe(this, Observer {
			when (it) {
				ToolbarActionMode.ToolbarActions.DELETE -> deleteRows()
				ToolbarActionMode.ToolbarActions.DESTROY -> destroyActionMode()
			}
		})
		viewModel.refresh()
	}

	override fun initViewDataBinding() {
		val binding: ActivityExerciseListBinding = DataBindingUtil.setContentView(this, R.layout.activity_exercise_list)
		binding.let {
			binding.setLifecycleOwner(this)
			binding.view = this
			binding.viewModel = ViewModelProviders.of(this, viewModelFactory).get(ExerciseListViewModel::class.java)
		}
	}

	override fun onAddButtonClick(view: View) {
	}

	private fun onListItemSelected(list: MutableList<ExerciseItemViewModel>) {
		if (!list.isEmpty() && actionMode == null) {
			actionMode = startSupportActionMode(toolbarActionMode)
		} else if (list.isEmpty() && actionMode != null) {
			actionMode!!.finish()
		}

		actionMode?.title = list.size.toString() + " " + getString(R.string.selected)
	}

	private fun destroyActionMode() {
		viewModel.setActionMode(arrayListOf())

		actionMode = null
	}

	private fun deleteRows() {
		load {
			viewModel.deleteSelectedExercises()
		} then {
			actionMode?.finish()
		}
	}
}

