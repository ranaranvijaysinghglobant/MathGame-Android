package com.shubhamdani.mathgame;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MainGamePresenterImplTest {

    @Mock
    GameView view;

    MainGamePresenterImpl presenter;

    @Before
    public void setUp() {
        presenter = new MainGamePresenterImpl(view);
    }

    @Test
    public void startGameTest() {
        presenter.startGame();
        verify(view).startTimer();
        verify(view).resetNumber(presenter.getGenerateRandomNumber());
    }

    @Test
    public void getGenerateRandomNumberTestForNumberLessThan10000() {
        int number = presenter.getGenerateRandomNumber();
        assertTrue(number < 10000);
    }
}
