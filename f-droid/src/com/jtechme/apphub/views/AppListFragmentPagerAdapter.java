package com.jtechme.apphub.views;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.jtechme.apphub.FDroid;
import com.jtechme.apphub.R;
import com.jtechme.apphub.compat.TabManager;
import com.jtechme.apphub.data.AppProvider;
import com.jtechme.apphub.views.fragments.AppListFragment;
import com.jtechme.apphub.views.fragments.AvailableAppsFragment;
import com.jtechme.apphub.views.fragments.CanUpdateAppsFragment;
import com.jtechme.apphub.views.fragments.InstalledAppsFragment;

/**
 * Used by the FDroid activity in conjunction with its ViewPager to support
 * swiping of tabs for both old devices (< 3.0) and new devices.
 *
 * See http://stackoverflow.com/a/15261142 for how to obtain references
 * to fragments in order to update them in response to search queries.
 */
public class AppListFragmentPagerAdapter extends FragmentPagerAdapter {

    @NonNull private final FDroid parent;
    @Nullable private String searchQuery;

    private final AppListFragment[] registeredFragments = new AppListFragment[TabManager.INDEX_COUNT];

    public AppListFragmentPagerAdapter(@NonNull FDroid parent) {
        super(parent.getSupportFragmentManager());
        this.parent = parent;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        AppListFragment fragment = (AppListFragment) super.instantiateItem(container, position);
        fragment.updateSearchQuery(searchQuery);
        registeredFragments[position] = fragment;
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredFragments[position] = null;
        super.destroyItem(container, position, object);
    }

    private String getInstalledTabTitle() {
        int installedCount = AppProvider.Helper.count(parent, AppProvider.getInstalledUri());
        return parent.getString(R.string.tab_installed_apps_count, installedCount);
    }

    private String getUpdateTabTitle() {
        int updateCount = AppProvider.Helper.count(parent, AppProvider.getCanUpdateUri());
        return parent.getString(R.string.tab_updates_count, updateCount);
    }

    public void updateSearchQuery(@Nullable String query) {
        searchQuery = query;
        for (AppListFragment fragment : registeredFragments) {
            if (fragment != null) {
                fragment.updateSearchQuery(query);
            }
        }
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case TabManager.INDEX_AVAILABLE:
                return new AvailableAppsFragment();
            case TabManager.INDEX_INSTALLED:
                return new InstalledAppsFragment();
            default:
                return new CanUpdateAppsFragment();
        }
    }

    @Override
    public int getCount() {
        return TabManager.INDEX_COUNT;
    }

    @Override
    public String getPageTitle(int i) {
        switch (i) {
            case TabManager.INDEX_AVAILABLE:
                return parent.getString(R.string.tab_available_apps);
            case TabManager.INDEX_INSTALLED:
                return getInstalledTabTitle();
            case TabManager.INDEX_CAN_UPDATE:
                return getUpdateTabTitle();
            default:
                return "";
        }
    }

}
