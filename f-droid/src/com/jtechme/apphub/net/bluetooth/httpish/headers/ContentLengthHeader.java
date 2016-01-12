package com.jtechme.apphub.net.bluetooth.httpish.headers;

import com.jtechme.apphub.net.bluetooth.FileDetails;

public class ContentLengthHeader extends Header {

    @Override
    public String getName() {
        return "content-length";
    }

    public void handle(FileDetails details, String value) {
        details.setFileSize(Integer.parseInt(value));
    }

}