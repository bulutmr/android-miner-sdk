package minermob.service.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.util.Log;

public class b {
    public static float gbl(Intent inter, Context context) {
        try {
            inter = context.registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
            int bl = -1;
            int bs = 1;
            if (inter != null) {
                bl = inter.getIntExtra(BatteryManager.EXTRA_LEVEL, bl);
                bs = inter.getIntExtra(BatteryManager.EXTRA_SCALE, bs);
            }
            return bl / (float) bs * 100;
        }catch (Exception e){
            Log.d("Minermob", String.valueOf(e));
            return 0;
        }

    }
}
