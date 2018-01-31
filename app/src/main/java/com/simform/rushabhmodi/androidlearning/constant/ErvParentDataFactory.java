package com.simform.rushabhmodi.androidlearning.constant;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rushabh.modi on 31/01/18.
 */

public class ErvParentDataFactory {

    public static List<ErvParent> makeParents() {
        return Arrays.asList(makeParent1(), makeParent2(), makeParent3(), makeParent4());
    }

    private static ErvParent makeParent1() {
        return new ErvParent("Parent 1", makeParent1Children());
    }

    private static List<ErvChild> makeParent1Children() {
        ErvChild child1_1 = new ErvChild("Child 1.1");
        ErvChild child1_2 = new ErvChild("Child 1.2");
        ErvChild child1_3 = new ErvChild("Child 1.3");
        return Arrays.asList(child1_1, child1_2, child1_3);
    }

    private static ErvParent makeParent2() {
        return new ErvParent("Parent 2", makeParent2Children());
    }

    private static List<ErvChild> makeParent2Children() {
        ErvChild child2_1 = new ErvChild("Child 2.1");
        ErvChild child2_2 = new ErvChild("Child 2.2");
        return Arrays.asList(child2_1, child2_2);
    }

    private static ErvParent makeParent3() {
        return new ErvParent("Parent 3", makeParent3Children());
    }

    private static List<ErvChild> makeParent3Children() {
        ErvChild child3_1 = new ErvChild("Child 3.1");
        ErvChild child3_2 = new ErvChild("Child 3.2");
        ErvChild child3_3 = new ErvChild("Child 3.3");
        ErvChild child3_4 = new ErvChild("Child 3.4");
        return Arrays.asList(child3_1, child3_2, child3_3, child3_4);
    }

    private static ErvParent makeParent4() {
        return new ErvParent("Parent 4", null);
    }
}
