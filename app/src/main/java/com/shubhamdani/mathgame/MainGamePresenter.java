package com.shubhamdani.mathgame;

import org.jetbrains.annotations.Nullable;

public interface MainGamePresenter<T> extends BasePresenter<T> {
    void startGame();
    void resetGame();
    void checkValues(@Nullable String value);
}

