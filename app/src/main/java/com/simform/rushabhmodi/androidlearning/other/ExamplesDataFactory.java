package com.simform.rushabhmodi.androidlearning.other;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rushabh.modi on 01/02/18.
 */

public class ExamplesDataFactory {

    public static final String parent1 = "Gestures";
    public static final String parent2 = "Intents";
    public static final String parent3 = "Expandable RecyclerView";
    public static final String parent4 = "Fragment";
    public static final String parent5 = "Storage";
    public static final String parent6 = "Collapsing Toolbar";
    public static final String parent7 = "ScrollView";
    public static final String parent8 = "SearchView";
    public static final String parent9 = "WebView";
    public static final String parent10 = "TextInput";
    public static final String parent11 = "Design Support Library";
    public static final String parent12 = "Widgets";

    public static final String parent4child1 = "Dialog Fragment";
    public static final String parent4child2 = "List Fragment";

    public static final String parent5child1 = "Shared Preferences";
    public static final String parent5child2 = "Internal Storage";
    public static final String parent5child3 = "External Storage";
    public static final String parent5child4 = "Sqlite Database";
    public static final String parent5child5 = "Room Persistent Library";

    public static final String parent8child1 = "Simple SearchView";
    public static final String parent8child2 = "Enhanced SearchView";

    public static List<ExamplesParent> makeParents() {
        return Arrays.asList(makeParent1(), makeParent2(), makeParent3(), makeParent4(), makeParent5(), makeParent6(), makeParent7(), makeParent8(), makeParent9(), makeParent10(), makeParent11(), makeParent12());
    }

    private static ExamplesParent makeParent1() {
        return new ExamplesParent(parent1, null);
    }

    private static ExamplesParent makeParent2() {
        return new ExamplesParent(parent2, null);
    }

    private static ExamplesParent makeParent3() {
        return new ExamplesParent(parent3, null);
    }


    private static ExamplesParent makeParent4() {
        return new ExamplesParent(parent4, makeParent4Children());
    }

    private static List<ExamplesChild> makeParent4Children() {
        ExamplesChild child4_1 = new ExamplesChild(parent4child1);
        ExamplesChild child4_2 = new ExamplesChild(parent4child2);
        return Arrays.asList(child4_1, child4_2);
    }

    private static ExamplesParent makeParent5() {
        return new ExamplesParent(parent5, makeParent5Children());
    }

    private static List<ExamplesChild> makeParent5Children() {
        ExamplesChild child5_1 = new ExamplesChild(parent5child1);
        ExamplesChild child5_2 = new ExamplesChild(parent5child2);
        ExamplesChild child5_3 = new ExamplesChild(parent5child3);
        ExamplesChild child5_4 = new ExamplesChild(parent5child4);
        ExamplesChild child5_5 = new ExamplesChild(parent5child5);
        return Arrays.asList(child5_1, child5_2, child5_3, child5_4, child5_5);
    }

    private static ExamplesParent makeParent6() {
        return new ExamplesParent(parent6, null);
    }

    private static ExamplesParent makeParent7() {
        return new ExamplesParent(parent7, null);
    }

    private static ExamplesParent makeParent8() {
        return new ExamplesParent(parent8, makeParent8Children());
    }

    private static List<ExamplesChild> makeParent8Children() {
        ExamplesChild child8_1 = new ExamplesChild(parent8child1);
        ExamplesChild child8_2 = new ExamplesChild(parent8child2);
        return Arrays.asList(child8_1, child8_2);
    }

    private static ExamplesParent makeParent9() {
        return new ExamplesParent(parent9, null);
    }

    private static ExamplesParent makeParent10() {
        return new ExamplesParent(parent10, null);
    }

    private static ExamplesParent makeParent11() {
        return new ExamplesParent(parent11, null);
    }

    private static ExamplesParent makeParent12() {
        return new ExamplesParent(parent12, null);
    }
}
