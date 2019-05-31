// IPerson.aidl
package com.hofo.aidlservice;

// Declare any non-default types here with import statements
import com.hofo.aidlservice.Eye;
interface IPerson {
    String getName();
    void setName(String name);
    Eye getEye();
    void setEye(in Eye eye);
}
