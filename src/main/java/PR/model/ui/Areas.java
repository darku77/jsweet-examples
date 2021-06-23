// =============================================================================
// Copyright/Security Notice
//
// Licensed Materials - Property of Qnamic AG
// (C) Copyright Qnamic AG 2003-2021
// All rights reserved
//
// End Copyright
// =============================================================================
package PR.model.ui;

import java.util.Arrays;
import java.util.List;

/**
 * @author catalin on 5/4/2018.
 */
public class Areas {

    public static final String ONBOARD = "O";
    public static final String TRACTION = "T";
    public static final String C = "C";
    public static final String D = "D";

    public static List<String> getAreas() {
        return Arrays.asList(TRACTION, ONBOARD, C, D);
    }

    public static String[] _getAreas() {
        return getAreas().toArray(new String[0]);
    }
}
