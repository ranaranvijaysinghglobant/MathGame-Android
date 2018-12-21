package com.shubhamdani.mathgame;

public interface BasePresenter<T> {
    void attach(T view);
    void detach();
    T getView();
    boolean isViewAttached();
}

