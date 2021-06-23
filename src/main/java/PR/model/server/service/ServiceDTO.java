// =============================================================================
// Copyright/Security Notice
//
// Licensed Materials - Property of Qnamic AG
// (C) Copyright Qnamic AG 2003-2021
// All rights reserved
//
// End Copyright
// =============================================================================
package PR.model.server.service;

import static PR.model.server.RailMLConsts.SignInStates.READY_TO_SIGN_IN;
import static PR.model.server.RailMLConsts.SignInStates.SIGNED_IN;
import static PR.model.server.RailMLConsts.SignOffStates.READY_TO_SIGN_OFF;
import static PR.model.server.RailMLConsts.SignOffStates.SIGNED_OFF;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import PR.model.server.service.resources.AbstractResourceDTO;
import PR.model.server.service.resources.PersonResourceDTO;
import PR.model.server.service.sequence.ActivitySequenceDTO;
import PR.model.server.service.sequence.activities.AbstractActivityDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ServiceDTO {


    private static final int FIRST = 0;

    public static class StateModelDTO {

        @Override
        public String toString() {
            return code;
        }

        private String code;
        private String currentState;
        private String name;
        private String description;
        private String lang;
        private Date timestamp;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCurrentState() {
            return currentState;
        }

        public void setCurrentState(String currentState) {
            this.currentState = currentState;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public Date getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Date timestamp) {
            this.timestamp = timestamp;
        }

    }

    // BODY////////////////////////
    /////////////////////////////
    private Long sid;

    private String id; // serviceId

    private String name; // serviceName

    private String editingStatus; // whether this service has been edited before and its editing status

    private String personnelNumber;

    private String personnelName;

    private Date timeTableDay;

    private Integer operatingDay;

    private Date start;

    private Date end;

    private Long length; // serviceLength

    private Long worktime;

    private Long grossWorktime;

    private Long breakTime;

    private Long breakBonus;

    private Long overtime;

    private List<StateModelDTO> stateModelDTOs = new ArrayList<>();

    private List<ActivitySequenceDTO> activitySequenceDTOs;

    @JsonIgnore
    public List<AbstractActivityDTO> getActivityDTOs() {
        List<AbstractActivityDTO> activities = new ArrayList<>();
        if (!Objects.isNull(activitySequenceDTOs) && activitySequenceDTOs.isEmpty()) {
            return activities;
        }
        for (ActivitySequenceDTO activitySequence : activitySequenceDTOs) {
            activities.addAll(activitySequence.getActivityDTOs());

        }
        return activities;
    }

    /**
     * Return only the NPA services, no train nor complex activities
     */
    @JsonIgnore
    public List<AbstractActivityDTO> getNPAActivityDTOs() {
        List<AbstractActivityDTO> activities = new ArrayList<>();
        if (!Objects.isNull(activitySequenceDTOs) && activitySequenceDTOs.isEmpty()) {
            return activities;
        }
        for (ActivitySequenceDTO activitySequence : activitySequenceDTOs) {
            List<AbstractActivityDTO> aa = activitySequence.getActivityDTOs();
            for (AbstractActivityDTO a : aa) {
                if (a.isNonProductiveActivity()) {
                    activities.add(a);
                }
            }
        }
        return activities;
    }

    @JsonIgnore
    public Optional<PersonResourceDTO> getPersonnel() {
        if (hasSequences()) {
            AbstractResourceDTO resource = activitySequenceDTOs.get(FIRST).getActivityDTOs().get(FIRST).getResource();
            if (resource.isPersonResourceTYPE()) {
                return Optional.of((PersonResourceDTO) resource);
            }
        }
        return Optional.empty();
    }

    @JsonIgnore
    public String getFrom() {
        if (hasSequences()) {
            return activitySequenceDTOs.get(FIRST).getFrom();
        }
        return "";
    }

    @JsonIgnore
    public String getTo() {
        if (hasSequences()) {
            return activitySequenceDTOs.get(activitySequenceDTOs.size() - 1).getTo();
        }
        return "";
    }

    @JsonIgnore
    public boolean checkState(String state) {
        List<StateModelDTO> states = getStateModelDTOs();
        return !Objects.isNull(states) && states.stream().anyMatch(s -> state.equals(s.getCurrentState()));
    }

    @JsonIgnore
    public String getSignInOffStateToDisplay() {
        List<StateModelDTO> states = getStateModelDTOs();
        if (!Objects.isNull(states)) {
            for (StateModelDTO s : states) {
                if (SIGNED_OFF.toString().equals(s.getCurrentState())) {
                    return s.getDescription();
                }
                if (SIGNED_IN.toString().equals(s.getCurrentState()) && !isSignedOff()) {
                    return s.getDescription();
                }
            }
        }
        return "";
    }

    @JsonIgnore
    public boolean isSignedIn() {
        return checkState(SIGNED_IN.toString());
    }

    @JsonIgnore
    public boolean isSignedOff() {
        return checkState(SIGNED_OFF.toString());
    }

    @JsonIgnore
    public boolean canSignOff() {
        return checkState(READY_TO_SIGN_OFF.toString());
    }

    @JsonIgnore
    public boolean canSignIn() {
        return checkState(READY_TO_SIGN_IN.toString());
    }

    private boolean hasSequences() {
        return !Objects.isNull(activitySequenceDTOs) && !activitySequenceDTOs.isEmpty();
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTimeTableDay() {
        return timeTableDay;
    }

    public void setTimeTableDay(Date timeTableDay) {
        this.timeTableDay = timeTableDay;
    }

    public Integer getOperatingDay() {
        return operatingDay;
    }

    public void setOperatingDay(Integer operatingDay) {
        this.operatingDay = operatingDay;
    }

    public List<ActivitySequenceDTO> getActivitySequenceDTOs() {
        return activitySequenceDTOs;
    }

    public void setActivitySequenceDTOs(List<ActivitySequenceDTO> activitySequenceDTOs) {
        this.activitySequenceDTOs = activitySequenceDTOs;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public Long getWorktime() {
        return worktime;
    }

    public void setWorktime(Long worktime) {
        this.worktime = worktime;
    }

    public Long getGrossWorktime() {
        return grossWorktime;
    }

    public void setGrossWorktime(Long grossWorktime) {
        this.grossWorktime = grossWorktime;
    }

    public Long getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(Long breakTime) {
        this.breakTime = breakTime;
    }

    public Long getBreakBonus() {
        return breakBonus;
    }

    public void setBreakBonus(Long breakBonus) {
        this.breakBonus = breakBonus;
    }

    public Long getOvertime() {
        return overtime;
    }

    public void setOvertime(Long overtime) {
        this.overtime = overtime;
    }

    public List<StateModelDTO> getStateModelDTOs() {
        return stateModelDTOs;
    }

    public void setStateModelDTOs(List<StateModelDTO> stateModelDTOs) {
        this.stateModelDTOs = stateModelDTOs;
    }

    public String getPersonnelNumber() {
        return personnelNumber;
    }

    public void setPersonnelNumber(String personnelNumber) {
        this.personnelNumber = personnelNumber;
    }

    public String getPersonnelName() {
        return personnelName;
    }

    public void setPersonnelName(String personnelName) {
        this.personnelName = personnelName;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getEditingStatus() {
        return editingStatus;
    }

    public void setEditingStatus(String editingStatus) {
        this.editingStatus = editingStatus;
    }

    @Override
    public String toString() {
        return id + "@" + name;
    }
}
