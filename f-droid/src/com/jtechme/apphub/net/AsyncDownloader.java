package com.jtechme.apphub.net;

import com.jtechme.apphub.ProgressListener;

public interface AsyncDownloader {

    interface Listener extends ProgressListener {
        void onErrorDownloading(String localisedExceptionDetails);

        void onDownloadComplete();

        void onDownloadCancelled();
    }

    int getBytesRead();

    int getTotalBytes();

    void download();

    void attemptCancel(boolean userRequested);

}
