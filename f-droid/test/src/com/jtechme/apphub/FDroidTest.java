package com.jtechme.apphub;

import android.annotation.TargetApi;
import android.os.Build;
import android.test.ActivityInstrumentationTestCase2;

@TargetApi(Build.VERSION_CODES.CUPCAKE)
public class FDroidTest extends ActivityInstrumentationTestCase2<FDroid> {

    public FDroidTest() {
        super("com.jtechme.apphub", FDroid.class);
    }

}
