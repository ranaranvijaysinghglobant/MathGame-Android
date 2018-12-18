package com.shubhamdani.mathgame;

import android.app.Application;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class GameApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/custom_font.otf")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }
}
