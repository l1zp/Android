package com.lizp.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by Lizp on 2017/6/9.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
