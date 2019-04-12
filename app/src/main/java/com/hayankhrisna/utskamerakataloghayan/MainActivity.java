package com.hayankhrisna.utskamerakataloghayan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG =MainActivity.class.getSimpleName() ;

    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openKameraList(View view){
        Intent intent = new Intent(MainActivity.this, KameraList.class);
        startActivity(intent);

    }
    public void openAbout(View view){
        Intent intent = new Intent(MainActivity.this, About.class);
        startActivity(intent);
    }
    public void openTambahList(View view){
        Intent intent = new Intent(MainActivity.this, TambahList.class);
        startActivity(intent);
    }

    public void openLogout(View view) {
        Log.d(LOG_TAG, "Logout");

        sharedPrefManager = new SharedPrefManager(this);

        sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, false);
        startActivity(new Intent(MainActivity.this, LoginActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
        finish();
    }
}
