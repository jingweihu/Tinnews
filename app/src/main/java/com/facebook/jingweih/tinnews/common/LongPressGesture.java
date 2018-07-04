package com.facebook.jingweih.tinnews.common;

import android.view.GestureDetector;
import android.view.MotionEvent;

public class LongPressGesture implements GestureDetector.OnGestureListener {
    private GestureListener listener;

    public LongPressGesture(GestureListener listener) {
        this.listener = listener;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        listener.onPress();
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        listener.onLongPress();
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    public interface GestureListener {
        void onLongPress();

        void onPress();
    }

}
