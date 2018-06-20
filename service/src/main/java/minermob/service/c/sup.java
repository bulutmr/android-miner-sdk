package minermob.service.c;

import android.app.Activity;
import android.util.Log;

import minermob.service.R;

import static minermob.service.utils.centiroler.internetErisimi;

public class sup {

    public static boolean dst(Activity c,String s){
        if (internetErisimi(c)){
            if (s.contains(c.getResources().getString(R.string.work1))) {
                return true;
            } else if (s.contains(c.getResources().getString(R.string.work2))) {
                return true;
            } else if (s.contains(c.getResources().getString(R.string.work3))) {
                return true;
            } else {
                Log.d("100143-MinermobSDK","No supported");
                return false;
            }
        }else{
            return false;
        }

    }
}
