package com.simform.rushabhmodi.androidlearning.other;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rushabh.modi on 01/02/18.
 */

public class ExamplesChild implements Parcelable {

    private String examplesChildText;

    public ExamplesChild(String examplesChildText) {
        this.examplesChildText = examplesChildText;
    }

    protected ExamplesChild(Parcel in) {
        examplesChildText = in.readString();
    }

    public String getExamplesChildText() {
        return examplesChildText;
    }

    public static final Creator<ExamplesChild> CREATOR = new Creator<ExamplesChild>() {
        @Override
        public ExamplesChild createFromParcel(Parcel in) {
            return new ExamplesChild(in);
        }

        @Override
        public ExamplesChild[] newArray(int size) {
            return new ExamplesChild[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(examplesChildText);
    }
}
