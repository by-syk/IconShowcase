/*
 * Copyright (c) 2016. Jahir Fiquitiva. Android Developer. All rights reserved.
 */

package jahirfiquitiva.iconshowcase.views;

import android.view.View;


/**
 * Debounced ClickListener
 * Rejects clicks that are too close together in time.
 * This class is safe to use as an OnClickListener for multiple views, and will debounce each one separately.
 */
public abstract class DebouncedClickListener implements View.OnClickListener {

    private boolean clickable = true;

    /**
     * Override onOneClick() instead.
     */
    @Override
    public final void onClick(View v) {
        if (clickable) {
            clickable = false;
            onDebouncedClick(v);
            reset(); //comment to disable automatic reset
        }
    }

    /**
     * Override this function to handle clicks.
     * reset() must be called after each click for this function to be called
     * again.
     *
     * @param v
     */
    public abstract void onDebouncedClick(View v);

    /**
     * Allows another click.
     */
    private void reset() {
        clickable = true;
    }

}