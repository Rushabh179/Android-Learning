package com.simform.rushabhmodi.androidlearning.other;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rushabh.modi on 01/02/18.
 */

public class TestExamplesChild implements Parcelable {

    private String testChild;

    public TestExamplesChild(String testChild) {
        this.testChild = testChild;
    }

    protected TestExamplesChild(Parcel in) {
        testChild = in.readString();
    }

    public String getTestChild() {
        return testChild;
    }

    public static final Creator<TestExamplesChild> CREATOR = new Creator<TestExamplesChild>() {
        @Override
        public TestExamplesChild createFromParcel(Parcel in) {
            return new TestExamplesChild(in);
        }

        @Override
        public TestExamplesChild[] newArray(int size) {
            return new TestExamplesChild[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(testChild);
    }
}
