package com.simform.rushabhmodi.androidlearning.other;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by rushabh.modi on 01/02/18.
 */

public class TestExamplesParent extends ExpandableGroup<TestExamplesChild> {

    public TestExamplesParent(String title, List<TestExamplesChild> items) {
        super(title, items);
    }

}
