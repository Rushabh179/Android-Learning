package com.simform.rushabhmodi.androidlearning.other;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by rushabh.modi on 01/02/18.
 */

public class ExamplesParent extends ExpandableGroup<ExamplesChild> {

    public ExamplesParent(String title, List<ExamplesChild> items) {
        super(title, items);
    }

}
