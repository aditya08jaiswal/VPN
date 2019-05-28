package com.iam844.adityajaiswal.vpn;

import android.content.Intent;
import android.net.VpnService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.net.DatagramSocket;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent intent = VpnService.prepare(getApplicationContext());
        if (intent != null) {
            startActivityForResult(intent, 0);
        } else {
            onActivityResult(0, RESULT_OK, null);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Intent intent = new Intent(this, MyVpnService.class);
            startService(intent);
        }
    }
}
