// =============================================================================
// Copyright/Security Notice
//
// Licensed Materials - Property of Qnamic AG
// (C) Copyright Qnamic AG 2003-2021
// All rights reserved
//
// End Copyright
// =============================================================================
package PR.model.server.service.sequence;

import java.util.ArrayList;
import java.util.List;

import PR.model.server.service.sequence.activities.AbstractActivityDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ActivitySequenceDTO {

    private static final int FIRST = 0;

    private String id;
    private String from;
    private String to;
    private String start;
    private String end;

    private final List<AbstractActivityDTO> activityDTOs = new ArrayList<>();

    @JsonIgnore
    public boolean isNonProductiveActivitySequence() {
        AbstractActivityDTO a = activityDTOs.get(FIRST);
        return a.isActivityTYPENPA() && a.isNonProductiveActivity();
    }

    @JsonIgnore
    public boolean isTrainActivitySequence() {
        AbstractActivityDTO a = activityDTOs.get(FIRST);
        return a.isActivityTYPETrain() && a.isTrainActivity();
    }

    @JsonIgnore
    public boolean containsChangedActivities() {
        for (AbstractActivityDTO activity : activityDTOs) {
            if (activity.getChangeStateDTO() != null) {
                return true;
            }
        }
        return false;
    }

    @JsonIgnore
    public boolean hasComments() {
        for (AbstractActivityDTO activity : activityDTOs) {
            if (activity.getComment() != null) {
                return true;
            }
        }
        return false;
    }

    public void addActivity(AbstractActivityDTO activity) {
        activityDTOs.add(activity);
    }

    public List<AbstractActivityDTO> getActivityDTOs() {
        return activityDTOs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTo() {
        if (to == null && !activityDTOs.isEmpty()) {
            to = activityDTOs.get(activityDTOs.size() - 1).getTo();
        }
        return to;
    }

    public String getFrom() {
        if (from == null && !activityDTOs.isEmpty()) {
            from = activityDTOs.get(FIRST).getFrom();
        }
        return from;
    }

    public String getStart() {
        if (start == null && !activityDTOs.isEmpty()) {
            start = activityDTOs.get(FIRST).getStartTime();
        }
        return start;
    }

    public String getEnd() {
        if (end == null && !activityDTOs.isEmpty()) {
            end = activityDTOs.get(activityDTOs.size() - 1).getEndTime();
        }
        return end;
    }

    @Override
    public String toString() {
        return id + "[" + getFrom() + "-" + getTo() + "/" + getStart() + "-" + getEnd() + "]";
    }
}

