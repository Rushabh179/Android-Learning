package com.simform.rushabhmodi.androidlearning.other;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rushabh.modi on 01/02/18.
 */

public class TestExamplesDataFactory {

    public static List<TestExamplesParent> makeTestParents() {
        return Arrays.asList(makeTestParent1(), makeTestParent2(), makeTestParent3(), makeTestParent4(), makeTestParent5(), makeTestParent6(), makeTestParent7());
    }

    private static TestExamplesParent makeTestParent1() {
        return new TestExamplesParent("Gestures", null);
    }

    private static TestExamplesParent makeTestParent2() {
        return new TestExamplesParent("Intents", null);
    }

    private static TestExamplesParent makeTestParent3() {
        return new TestExamplesParent("Expandable RecyclerView", null);
    }

    private static TestExamplesParent makeTestParent4() {
        return new TestExamplesParent("Fragment", makeTestParent4Children());
    }

    private static List<TestExamplesChild> makeTestParent4Children() {
        TestExamplesChild child4_1 = new TestExamplesChild("Dialog Fragment");
        TestExamplesChild child4_2 = new TestExamplesChild("List Fragment");
        return Arrays.asList(child4_1, child4_2);
    }

    private static TestExamplesParent makeTestParent5() {
        return new TestExamplesParent("Storage", makeTestParent5Children());
    }

    private static List<TestExamplesChild> makeTestParent5Children() {
        TestExamplesChild child5_1 = new TestExamplesChild("Shared Preferences");
        TestExamplesChild child5_2 = new TestExamplesChild("Internal Storage");
        TestExamplesChild child5_3 = new TestExamplesChild("External Storage");
        return Arrays.asList(child5_1, child5_2, child5_3);
    }

    private static TestExamplesParent makeTestParent6() {
        return new TestExamplesParent("Example 6", null);
    }

    private static TestExamplesParent makeTestParent7() {
        return new TestExamplesParent("Example 7", null);
    }
}
