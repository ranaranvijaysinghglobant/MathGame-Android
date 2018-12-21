package com.shubhamdani.mathgame

import java.lang.ref.WeakReference

open class BaseGamePresenter<T> : BasePresenter<T> {

    lateinit var weakView: WeakReference<T>

    override fun attach(view: T) {
        this.weakView = WeakReference(view)
    }

    override fun getView(): T? {
        return weakView.get()
    }

    override fun detach() {
        weakView.clear()
    }

    override fun isViewAttached(): Boolean {
        return weakView.get() != null
    }
}
