package com.shubhamdani.mathgame;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

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
    public void resetGameTest() {
        presenter.resetGame();
        verify(view).restartTimer();
        assertEquals(0, presenter.getScores());
        verify(view).displayScores(0);
        verify(view).resetInput();
        verify(view).resetNumber(any(Integer.class));
    }


    @Test
    public void nextNumberTest() {
        presenter.nextNumber();
        verify(view).restartTimer();
        verify(view).resetNumber(any(Integer.class));
        verify(view).resetInput();
    }

    @Test
    public void checkValueEmptyStringTest() {
        presenter.checkValues("");
        verifyZeroInteractions(view);
    }

    @Test
    public void checkValueNullTest() {
        presenter.checkValues(null);
        verifyZeroInteractions(view);
    }

    @Test
    public void checkValueIncorrectValueLengthTest() {
        presenter.checkValues("123");
        verifyZeroInteractions(view);
    }

//    @Rule
//    public ExpectedException expectedException = ExpectedException.none();

//    @Test
//    public void checkValueIncorrectValueTest() {
//        expectedException.expect(NumberFormatException.class);
//        presenter.checkValues("234esd");
//    }

    @Test
    public void checkValueWrongInputTest() {
        presenter.setGenerateRandomNumber(1233);
        presenter.checkValues("1233");
        verify(view).displayThumbsDown();
    }

    @Test
    public void checkValueCorrectInputTest() {
        presenter.setGenerateRandomNumber(1111);
        presenter.checkValues("2222");
        verify(view).displayThumbsup();
        verify(view).displayScores(any(Integer.class));
        assertEquals(1, presenter.getScores());
    }

    @Test
    public void getGenerateRandomNumberTestForNumberLessThan10000() {
        int number = presenter.getGenerateRandomNumber();
        assertTrue(number < 10000);
    }
}
