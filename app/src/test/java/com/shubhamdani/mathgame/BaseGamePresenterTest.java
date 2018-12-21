package com.shubhamdani.mathgame;

import android.view.View;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.lang.ref.WeakReference;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

@RunWith(MockitoJUnitRunner.class)
public class BaseGamePresenterTest {

    @Mock
    View view;

    BaseGamePresenter<View> presenter;

    @Before
    public void setUp() {
        presenter = new BaseGamePresenter<View>();
        presenter.attach(view);
    }

    @Test
    public void testViewNotNull() {
        assertNotNull(presenter.getView());
    }


    @Test
    public void testViewDetach() {
        presenter.detach();
        assertNull(presenter.getView());
    }


    @Test
    public void testIsViewAttachAfterDetach() {
        presenter.detach();
        assertFalse(presenter.isViewAttached());
    }

    @Test
    public void testIsViewAttachAfterAttach() {
        presenter.attach(view);
        assertTrue(presenter.isViewAttached());
    }


     @Test
    public void testIsWeakViewNotNull() {
        presenter.attach(view);
        assertNotNull(presenter.getWeakView());
    }

     @Test
    public void testIsWeakViewNull() {
        presenter.detach();
        assertNotNull(presenter.getWeakView());
    }


     @Test
    public void testSetWeakView() {
         WeakReference<View> newView = mock(WeakReference.class);
         presenter.setWeakView(newView);
        assertNotNull(presenter.getWeakView());
    }





}
