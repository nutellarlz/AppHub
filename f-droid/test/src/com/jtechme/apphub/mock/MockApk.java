package com.jtechme.apphub.mock;

import com.jtechme.apphub.data.Apk;

public class MockApk extends Apk {

    public MockApk(String id, int versionCode) {
        this.packageName = id;
        this.vercode = versionCode;
    }

}
