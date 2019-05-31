package com.hofo.aidlservice.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.hofo.aidlservice.Eye;
import com.hofo.aidlservice.IPerson;

public class PersonService extends Service {
    private String name;
    private Eye mEye;
    IPerson.Stub mPerson = new IPerson.Stub() {


        @Override
        public String getName() throws RemoteException {
            return name;
        }

        @Override
        public void setName(String name) throws RemoteException {
            PersonService.this.name = name;
        }

        @Override
        public Eye getEye() throws RemoteException {
            return mEye;
        }

        @Override
        public void setEye(Eye eye) throws RemoteException {
            PersonService.this.mEye = eye;
        }
    };

    public PersonService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mPerson;
    }
}
