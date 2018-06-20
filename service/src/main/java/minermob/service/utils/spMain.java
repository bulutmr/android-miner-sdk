package minermob.service.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class spMain {


    public spMain() {
    }

    public static void spSetBoolean(String tag, Context activity, Boolean deger){
        SharedPreferences sp2;
        SharedPreferences.Editor editor;
        sp2 = activity.getSharedPreferences(tag, Context.MODE_PRIVATE);
        editor = sp2.edit();
        editor.putBoolean(tag, deger);
        editor.apply();
    }
    public static void spSetString(String tag, Context activity, String deger){
        SharedPreferences sp2;
        SharedPreferences.Editor editor;
        sp2 = activity.getSharedPreferences(tag, Context.MODE_PRIVATE);
        editor = sp2.edit();
        editor.putString(tag, deger);
        editor.apply();
    }
    public static void spSetInt(String tag, Context activity, int deger){
        SharedPreferences sp2;
        SharedPreferences.Editor editor;
        sp2 = activity.getSharedPreferences(tag, Context.MODE_PRIVATE);
        editor = sp2.edit();
        editor.putInt(tag, deger);
        editor.apply();
    }
    public static void spSetFloat(String tag, Context activity, float deger){
        SharedPreferences sp2;
        SharedPreferences.Editor editor;
        sp2 = activity.getSharedPreferences(tag, Context.MODE_PRIVATE);
        editor = sp2.edit();
        editor.putFloat(tag, deger);
        editor.apply();
    }
    public static void spSetLong(String tag, Context activity, long deger){
        SharedPreferences sp2;
        SharedPreferences.Editor editor;
        sp2 = activity.getSharedPreferences(tag, Context.MODE_PRIVATE);
        editor = sp2.edit();
        editor.putLong(tag, deger);
        editor.apply();
    }

    public static Boolean spGetBoolean(String tag, Context activity){
        SharedPreferences sp2 = activity.getSharedPreferences(tag, Context.MODE_PRIVATE);
        return sp2.getBoolean(tag, false);
    }

    public static String spGetString(String tag, Context activity){
        SharedPreferences sp2 = activity.getSharedPreferences(tag, Context.MODE_PRIVATE);
        return sp2.getString(tag, "");
    }

    public static int spGetInt(String tag, Context activity){
        SharedPreferences sp2 = activity.getSharedPreferences(tag, Context.MODE_PRIVATE);
        return sp2.getInt(tag, 0);
    }

    public static float spGetFloat(String tag, Context activity){
        SharedPreferences sp2 = activity.getSharedPreferences(tag, Context.MODE_PRIVATE);
        return sp2.getFloat(tag, 0);
    }

    public static float spGetLong(String tag, Context activity){
        SharedPreferences sp2 = activity.getSharedPreferences(tag, Context.MODE_PRIVATE);
        return sp2.getLong(tag, 0);
    }




}
