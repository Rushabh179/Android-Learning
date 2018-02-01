package com.simform.rushabhmodi.androidlearning.other;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rushabh.modi on 31/01/18.
 */

public class ErvChild implements Parcelable{

    private String child;

    public ErvChild(String child) {
        this.child = child;
    }

    protected ErvChild(Parcel in) {
        child = in.readString();
    }

    public String getChild() {
        return child;
    }

    public static final Creator<ErvChild> CREATOR = new Creator<ErvChild>() {
        @Override
        public ErvChild createFromParcel(Parcel in) {
            return new ErvChild(in);
        }

        @Override
        public ErvChild[] newArray(int size) {
            return new ErvChild[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(child);
    }
}
