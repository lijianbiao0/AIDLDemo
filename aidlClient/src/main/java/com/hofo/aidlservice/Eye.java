package com.hofo.aidlservice;

import android.os.Parcel;
import android.os.Parcelable;

public final class Eye implements Parcelable {
    public static final Creator<Eye> CREATOR = new Creator<Eye>() {
        @Override
        public Eye createFromParcel(Parcel in) {
            return new Eye(in);
        }

        @Override
        public Eye[] newArray(int size) {
            return new Eye[size];
        }
    };
    String eyeColor;

    public Eye(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    protected Eye(Parcel in) {
        eyeColor = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(eyeColor);
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }
}
