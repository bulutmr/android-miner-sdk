package minermob.service.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import minermob.service.c.MRC;

public class Filtreler {

    public static void ekle(Context activity) {
        try {
            IntentFilter filter = new IntentFilter();
            filter.addAction(Intent.ACTION_SCREEN_ON);
            filter.addAction(Intent.ACTION_SCREEN_OFF);
            filter.addAction(Intent.ACTION_USER_PRESENT);
            filter.addAction(Intent.ACTION_BATTERY_CHANGED);
            filter.addAction(Intent.ACTION_NEW_OUTGOING_CALL);
            filter.addAction(Intent.EXTRA_ALARM_COUNT);
            activity.registerReceiver(new MRC(), filter);

        } catch (Exception e) {

            Log.d("Minermob",String.valueOf(e));
        }

    }
}
