package com.lizp.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Lizp on 2017/6/7.
 */

public class CrimeLab {
    private static CrimeLab sCrimeLab;

    private List<Crime> mCrimes;
    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        mCrimes = new ArrayList<Crime>();
    }
    public List<Crime> getCrimes() {
        return mCrimes;
    }
    public Crime getCrime(UUID id) {
        for (Crime crime : mCrimes) {
            if (crime.getId().equals(id)){
                return crime;
            }
        }
        return null;
    }

    public void addCrime(Crime crime) {
        mCrimes.add(crime);
    }
}
