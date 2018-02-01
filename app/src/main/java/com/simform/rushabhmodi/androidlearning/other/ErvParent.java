package com.simform.rushabhmodi.androidlearning.other;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by rushabh.modi on 31/01/18.
 */

public class ErvParent extends ExpandableGroup<ErvChild> {

    public ErvParent(String title, List<ErvChild> items) {
        super(title, items);
    }
}
