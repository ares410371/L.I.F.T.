package com.ivet.lift.ui.activity

import android.app.SearchManager
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.view.ActionMode
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.LinearLayout.VERTICAL
import android.widget.Toast
import com.ivet.lift.R
import com.ivet.lift.databinding.ActivityExerciseListBinding
import com.ivet.lift.repository.data.Exercise
import com.ivet.lift.ui.adapter.ExerciseListAdapter
import com.ivet.lift.ui.view.ExerciseListView
import com.ivet.lift.ui.viewModel.ExerciseListViewModel
import com.ivet.lift.ui.viewModel.factory.ViewModelFactory
import com.ivet.lift.utils.ToolbarActionMode
import kotlinx.android.synthetic.main.activity_exercise_list.rv_exercises
import kotlinx.android.synthetic.main.activity_exercise_list.tv_toolbar
import javax.inject.Inject

class ExerciseListActivity : BaseActivity<ExerciseListViewModel>(), ExerciseListView {

	val STATE_SEARCH_VIEW = "search_view"

	@Inject
	lateinit var viewModelFactory: ViewModelFactory

	var actionMode: ActionMode? = null
	val toolbarActionMode: ToolbarActionMode = ToolbarActionMode()
	private var adapter: ExerciseListAdapter = ExerciseListAdapter(this)

	override fun onCreateOptionsMenu(menu: Menu): Boolean {
		val menuInflater = menuInflater
		menuInflater.inflate(R.menu.search_menu, menu)

		val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
		val menuItem = menu.findItem(R.id.action_search)
		val searchView = menuItem.actionView as SearchView

		if (!viewModel.searchQuery.isNullOrBlank()) {
			menuItem.expandActionView()
		}

		with(searchView) {
			setSearchableInfo(searchManager.getSearchableInfo(componentName))
			setIconifiedByDefault(false)

			post({
				setQuery(viewModel.searchQuery, true)
			})

		//	setQuery(viewModel.searchQuery, true)

		}

		initSearchViewListener(searchView);

		return super.onCreateOptionsMenu(menu)
	}

	override fun onResume() {
		super.onResume()
		//viewModel.setQuery("")
	}

	override fun initInjector() {
		activityComponent.inject(this)
	}

	override fun initViewModel() {
		viewModel = ViewModelProviders.of(this, viewModelFactory).get(ExerciseListViewModel::class.java)
		viewModel.result.observe(this, Observer {
			it?.let {
				adapter.exercises = it.toMutableList()

			}
		})
		lifecycle.addObserver(viewModel)
	}

	override fun initViewDataBinding() {
		val binding: ActivityExerciseListBinding = DataBindingUtil.setContentView(this, R.layout.activity_exercise_list)
		binding.let {
			binding.setLifecycleOwner(this)
			binding.view = this
		}
	}

	override fun getToolbar(): Toolbar = tv_toolbar

	override fun initViews() {
		initRecycleView()
		initActionMode()
	}

	override fun onItemLongClick(exercise: Exercise): Boolean {
		onListItemSelected(exercise)
		return true
	}

	override fun onItemClick(exercise: Exercise) {
		if (actionMode != null) {
			onListItemSelected(exercise)
		}
	}

	override fun onAddButtonClick(view: View) {
		startActivity(AddExerciseActivity.newIntent(this))
	}

	private fun onListItemSelected(exercise: Exercise) {
		adapter.toggleSelection(exercise)

		val hasCheckedItems = (adapter.selectedExercises.size() > 0)

		if (hasCheckedItems && actionMode == null) {
			actionMode = startSupportActionMode(toolbarActionMode)
		} else if (!hasCheckedItems && actionMode != null) {
			actionMode?.finish()
		}

		if (actionMode != null) {
			actionMode?.title = adapter.selectedExercises.size().toString() + " selected"
		}
	}

	private fun initActionMode() {
		compositeDisposable.add(toolbarActionMode.subject.subscribe(
			{
				when (it) {
					ToolbarActionMode.ToolbarActions.DELETE -> deleteRows()
					ToolbarActionMode.ToolbarActions.DESTROY -> destroyActionMode()

				}
			},
			{
				Log.e(TAG, it.localizedMessage)
			}
		))
	}

	private fun deleteRows() {
		for (i in adapter.selectedExercises.size() - 1 downTo 0) {
			compositeDisposable.add(viewModel.deleteExercise(adapter.exercises.get(adapter.selectedExercises.keyAt(i))).subscribe())
		}

		Toast.makeText(this, adapter.selectedExercises.size().toString() + " item deleted.", Toast.LENGTH_LONG).show()
		actionMode?.finish()
	}

	private fun destroyActionMode() {
		adapter.removeSelection()

		if (actionMode != null) {
			actionMode = null
		}
	}

	private fun initRecycleView() {
		initActionBar(tv_toolbar)
		rv_exercises.layoutManager = LinearLayoutManager(this)
		rv_exercises.addItemDecoration(DividerItemDecoration(this, VERTICAL))
		rv_exercises.adapter = adapter
	}

	private fun initSearchViewListener(searchView: SearchView) {
		compositeDisposable.add(
			viewModel.getSearchViewObservable(searchView)
				.subscribe({
					viewModel.setQuery(it)
//					viewModel.searchExercises(it).observe(this, Observer {
//						adapter.exercises = it?.toMutableList() ?: mutableListOf()
//					})
				}))
	}

}
