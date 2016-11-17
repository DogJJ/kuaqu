package com.wangqu.kuaqu.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by KingJ on 2015/11/19.
 */

public class SharedPreferencesUtil {
    public static String datastore = "data";

    public static void put(Context context, String key, String value) {

        SharedPreferences settings = context.getSharedPreferences(datastore,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void putint(Context context, String key, int value) {

        SharedPreferences settings = context.getSharedPreferences(datastore, Context.MODE_APPEND);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static String getString(Context context, String key) {
        SharedPreferences settings = context.getSharedPreferences(datastore,
                Context.MODE_PRIVATE);

        String arg = settings.getString(key, null);
        return arg;
    }

    public static Integer getint(Context context, String key) {
        SharedPreferences settings = context.getSharedPreferences(datastore,
                Context.MODE_PRIVATE);

        int arg = settings.getInt(key, 0);
        return arg;

    }

    public static void clear(Context context) {
        SharedPreferences settings = context.getSharedPreferences(datastore,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.clear();
        editor.commit();
    }


}