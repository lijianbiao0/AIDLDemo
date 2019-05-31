package com.hofo.aidlclient;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hofo.aidlservice.Eye;
import com.hofo.aidlservice.IPerson;

public class MainActivity extends AppCompatActivity {
    IPerson iPerson;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = findViewById(R.id.editText);

        Intent service = new Intent("com.hofo.aidlservice.service.PersonService");
        service.setPackage("com.hofo.aidlservice");
        bindService(service, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                iPerson = IPerson.Stub.asInterface(service);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                iPerson = null;
            }
        }, BIND_AUTO_CREATE);

    }

    public void getName(View view) {
        try {
            String name = iPerson.getName();
            Toast.makeText(this, "name = " + name, Toast.LENGTH_SHORT).show();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void setName(View view) {
        try {
            iPerson.setName(mEditText.getText().toString());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void setEye(View view) {
        try {
            iPerson.setEye(new Eye("绿色"));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void getEye(View view) {
        try {
            Toast.makeText(this, "眼睛颜色：" + iPerson.getEye().getEyeColor(), Toast.LENGTH_SHORT).show();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
