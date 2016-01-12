package com.jtechme.apphub.net.bluetooth.httpish.headers;

import com.jtechme.apphub.net.bluetooth.FileDetails;

public class ETagHeader extends Header {

    @Override
    public String getName() {
        return "etag";
    }

    public void handle(FileDetails details, String value) {
        details.setCacheTag(value);
    }

}
