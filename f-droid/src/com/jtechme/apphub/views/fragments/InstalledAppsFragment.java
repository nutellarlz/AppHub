package com.jtechme.apphub.views.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jtechme.apphub.R;
import com.jtechme.apphub.data.AppProvider;
import com.jtechme.apphub.views.AppListAdapter;
import com.jtechme.apphub.views.InstalledAppListAdapter;

public class InstalledAppsFragment extends AppListFragment {

    @Override
    protected AppListAdapter getAppListAdapter() {
        return new InstalledAppListAdapter(getActivity(), null);
    }

    @Override
    protected String getFromTitle() {
        return getString(R.string.tab_installed_apps);
    }

    @Override
    protected Uri getDataUri() {
        return AppProvider.getInstalledUri();
    }

    @Override
    protected Uri getDataUri(String query) {
        return AppProvider.getSearchInstalledUri(query);
    }

    @Override
    protected int getEmptyMessage() {
        return R.string.empty_installed_app_list;
    }

    @Override
    protected int getNoSearchResultsMessage() {
        return R.string.empty_search_installed_app_list;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.installed_app_list, container, false);
    }

}
