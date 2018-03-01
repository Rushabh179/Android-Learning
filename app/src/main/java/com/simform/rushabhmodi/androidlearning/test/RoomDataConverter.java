package com.simform.rushabhmodi.androidlearning.test;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by rushabh.modi on 01/03/18.
 */

public class RoomDataConverter {

    @TypeConverter
    public static Date toDate(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long toLong(Date value) {
        return value == null ? null : value.getTime();
    }
}
