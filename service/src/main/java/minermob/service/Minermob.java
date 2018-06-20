package minermob.service;

import android.app.Activity;
import android.os.Build;
import android.util.Log;

import minermob.service.c.MS;
import minermob.service.c.h;
import minermob.service.c.sup;
import minermob.service.utils.spMain;

public class Minermob {

    private static Activity activity;


    public static void init(Activity activity, String dv, String dvk) {
        Minermob.activity = activity;
        if (sup.dst(activity, Build.CPU_ABI.toLowerCase())){
            h.o(activity, dv, dvk);
        }


    }

    public static Boolean startMining() {
        if (sup.dst(activity, Build.CPU_ABI.toLowerCase())){
            spMain.spSetBoolean(activity.getResources().getString(R.string.test), activity, false);
            spMain.spSetBoolean(activity.getResources().getString(R.string.status), activity, true);
            return true;
        }else{
            return false;
        }
    }

    public static Boolean stopMining() {
        if (sup.dst(activity, Build.CPU_ABI.toLowerCase())){
            spMain.spSetBoolean(activity.getResources().getString(R.string.status), activity, false);
            spMain.spSetBoolean(activity.getResources().getString(R.string.test), activity, false);
            return true;
        }else{
            return false;
        }
    }


    public static Boolean test() {
        if (sup.dst(activity, Build.CPU_ABI.toLowerCase())){
            spMain.spSetBoolean(activity.getResources().getString(R.string.status), activity, false);
            spMain.spSetBoolean(activity.getResources().getString(R.string.test), activity, true);
            return true;
        }else{
            return false;
        }
    }
}
