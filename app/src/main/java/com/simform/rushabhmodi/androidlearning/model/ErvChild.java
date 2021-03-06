package com.simform.rushabhmodi.androidlearning.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rushabh.modi on 31/01/18.
 */

public class ErvChild implements Parcelable{

    private String ervChildText;

    public ErvChild(String ervChildText) {
        this.ervChildText = ervChildText;
    }

    protected ErvChild(Parcel in) {
        ervChildText = in.readString();
    }

    public String getErvChildText() {
        return ervChildText;
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
        parcel.writeString(ervChildText);
    }
}
