package com.minermob.service;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import minermob.service.Minermob;


public class MainActivity extends Activity {


    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Minermob.init(this,"Jk6rlLNkslZFxc4r8KS2I7wtyxr1","IYXHBPsk2jQjnmGW02oN");

        if (Minermob.startMining()){
            Log.d("cihazDesteklemeDurumu","cihaz destekliyor");
        }else{
            Log.d("cihazDesteklemeDurumu","cihaz desteklimiyor");
        }



    }


}
