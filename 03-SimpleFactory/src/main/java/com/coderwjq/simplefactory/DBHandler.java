package com.coderwjq.simplefactory;

import android.util.Log;

/**
 * @Created by coderwjq on 2017/6/5 11:32.
 * @Desc
 */

public class DBHandler extends IOHandler {
    private static final String TAG = "DBHandler";
    @Override
    public void insert() {
        super.insert();
        Log.d(TAG, "insert() called with database");
    }
}
