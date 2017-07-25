package com.huawu.fivesmart.audio.apm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("hwapmsdk");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_hello = (TextView) findViewById(R.id.tv_hello);
        tv_hello.setText(helloFromHWAPMSDK());
    }

    public native String helloFromHWAPMSDK();
}
