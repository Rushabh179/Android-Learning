package com.simform.rushabhmodi.androidlearning.other;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rushabh.modi on 01/02/18.
 */

public class ExamplesDataFactory {

    public static List<ExamplesParent> makeParents() {
        return Arrays.asList(makeParent1(), makeParent2(), makeParent3(), makeParent4(), makeParent5(), makeParent6(), makeParent7());
    }

    private static ExamplesParent makeParent1() {
        return new ExamplesParent("Gestures", null);
    }

    private static ExamplesParent makeParent2() {
        return new ExamplesParent("Intents", null);
    }

    private static ExamplesParent makeParent3() {
        return new ExamplesParent("Expandable RecyclerView", null);
    }

    private static ExamplesParent makeParent4() {
        return new ExamplesParent("Fragment", makeParent4Children());
    }

    private static List<ExamplesChild> makeParent4Children() {
        ExamplesChild child4_1 = new ExamplesChild("Dialog Fragment");
        ExamplesChild child4_2 = new ExamplesChild("List Fragment");
        return Arrays.asList(child4_1, child4_2);
    }

    private static ExamplesParent makeParent5() {
        return new ExamplesParent("Storage", makeParent5Children());
    }

    private static List<ExamplesChild> makeParent5Children() {
        ExamplesChild child5_1 = new ExamplesChild("Shared Preferences");
        ExamplesChild child5_2 = new ExamplesChild("Internal Storage");
        ExamplesChild child5_3 = new ExamplesChild("External Storage");
        return Arrays.asList(child5_1, child5_2, child5_3);
    }

    private static ExamplesParent makeParent6() {
        return new ExamplesParent("Example 6", null);
    }

    private static ExamplesParent makeParent7() {
        return new ExamplesParent("Example 7", null);
    }
}
