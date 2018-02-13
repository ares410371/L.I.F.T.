package com.pwl.lift.common

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.support.annotation.MainThread
import android.support.annotation.Nullable
import android.util.Log

class EventLiveData<T> : MutableLiveData<T>() {
	private var pending = false

	@MainThread
	override fun observe(owner: LifecycleOwner, observer: Observer<T>) {
		if (hasActiveObservers()) {
			Log.w("EventLiveData", "Multiple observers registered but only one will be notified of changes.")
		}

		// Observe the internal MutableLiveData
		super.observe(owner, Observer { t ->
			if (pending) {
				pending = false
				observer.onChanged(t)
			}
		})
	}

	@MainThread
	override fun setValue(@Nullable t: T?) {
		pending = true
		super.setValue(t)
	}

	/**
	 * Used for cases where T is Void, to make calls cleaner.
	 */
	@MainThread
	fun call() {
		setValue(null)
	}
}