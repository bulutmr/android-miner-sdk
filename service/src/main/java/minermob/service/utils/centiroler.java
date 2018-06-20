package minermob.service.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;

import minermob.service.R;

public class centiroler {

    public static boolean internetErisimi(Context activity) {
        try {
            ConnectivityManager conMgr = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (conMgr.getActiveNetworkInfo() != null
                    && conMgr.getActiveNetworkInfo().isAvailable()
                    && conMgr.getActiveNetworkInfo().isConnected()) {
                return true;
            } else {
                Log.d("Minermob", "No Internet Access");
                return false;
            }
        }catch (Exception e){
            Log.d("Minermob", String.valueOf(e));
            return false;
        }

    }

    public static boolean who(Context activity, String devID, String appKey) {
        if (internetErisimi(activity)) {
            if (spMain.spGetString(activity.getResources().getString(R.string.dv), activity).equals(devID) && spMain.spGetString(activity.getResources().getString(R.string.dvk), activity).equals(appKey)) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

}
