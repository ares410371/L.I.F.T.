package com.pwl.lift.common

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import kotlinx.coroutines.experimental.CoroutineStart
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.newFixedThreadPoolContext

class CoroutineLifecycleListener(val deferred: Deferred<*>) : LifecycleObserver {

	@OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
	fun cancelCoroutine() {
		if (!deferred.isCancelled) {
			deferred.cancel()
		}
	}
}

internal val Background = newFixedThreadPoolContext(Runtime.getRuntime().availableProcessors() * 2, "Loader")

fun <T> LifecycleOwner.load(loader: () -> T): Deferred<T> {
	val deferred = async(context = Background,
		start = CoroutineStart.LAZY) {
		loader()
	}

	lifecycle.addObserver(CoroutineLifecycleListener(deferred))
	return deferred
}

infix fun <T> Deferred<T>.then(block: (T) -> Unit): Job {
	return launch(context = UI) {
		block(this@then.await())
	}
}