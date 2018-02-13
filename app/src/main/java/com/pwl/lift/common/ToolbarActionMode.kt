package com.pwl.lift.common

import android.support.v7.view.ActionMode
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.pwl.lift.R

class ToolbarActionMode : ActionMode.Callback {

	val event = EventLiveData<ToolbarActions>()

	override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
		when (item?.itemId) {
			R.id.action_delete -> event.value = ToolbarActions.DELETE
		}

		return false
	}

	override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
		mode?.menuInflater?.inflate(R.menu.menu_main, menu)
		return true
	}

	override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
		menu?.findItem(R.id.action_delete)?.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
		return true
	}

	override fun onDestroyActionMode(mode: ActionMode?) {
		event.value = ToolbarActions.DESTROY
	}

	enum class ToolbarActions {
		DELETE,
		DESTROY
	}
}

