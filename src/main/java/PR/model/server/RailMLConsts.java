// =============================================================================
// Copyright/Security Notice
//
// Licensed Materials - Property of Qnamic AG
// (C) Copyright Qnamic AG 2003-2021
// All rights reserved
//
// End Copyright
// =============================================================================
package PR.model.server;

public final class RailMLConsts {

    private RailMLConsts() {
    }

    public enum Worktime {
        SERVICE_LENGTH,
        WORK_TIME,
        GROSS_WORK_TIME,
        BREAK_TIME,
        BREAK_BONUS,
        OVER_TIME_UEZ
    }

    public enum StateModelsTypes { // used to map code of a StateModel
        SIGN_IN,
        SIGN_OFF
    }

    public enum SignInStates { // used to map currentState of a StateModel
        READY_TO_SIGN_IN,
        SIGNED_IN
    }

    public enum SignOffStates { // used to map currentState of a StateModel
        READY_TO_SIGN_OFF,
        SIGNED_OFF
    }

    public enum VEHICLE_TYPE { // type of vehicles
        TYPE_ELEMENT,
        TYPE_MOTOR_COACH,
        TYPE_CONTROL_CAR,
        TYPE_VEHICLE
    }

    public static final String ACTIVITY_TYPE_NOTE_PUBLIC = "NOTE_PUBLIC";
    public static final String ACTIVITY_TYPE_LDAY = "LDAY";
    public static final String SERVICE = "SERVICE";

}
