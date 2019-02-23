package com.example.kresna.photography.data;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    public static final String KEY_DOWNLOAD = "sudahdownload";
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context _context;

    public SharedPref(Context context) {
        this._context = context;
        int PRIVATE_MODE = 0;
        pref = _context.getSharedPreferences("SharedPrefKresna", PRIVATE_MODE);
        editor = pref.edit();


    }

    /**
     * set variable download true/false
     *
     * @param b boolean
     */
    public void setDownload(boolean b) {
        editor.putBoolean(KEY_DOWNLOAD, b);
        editor.commit();
    }

    /**
     * Get nilai variable donwload di dalam sharedprefrence
     *
     * @return false jika null dan atau sudah diisi
     */
    public boolean isDownloaded() {
        return pref.getBoolean(KEY_DOWNLOAD, false);
    }
}
