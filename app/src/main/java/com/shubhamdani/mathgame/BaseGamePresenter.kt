package com.shubhamdani.mathgame

import java.lang.ref.WeakReference

abstract class BaseGamePresenter<T>: BasePresenter<T>  {

    lateinit var view: WeakReference<T>

    override fun attach(view: T) {
        this.view = WeakReference(view)
    }

    override fun getView(): T? {
        return view.get()
    }


    override fun detach() {
        view.clear()
    }
}
