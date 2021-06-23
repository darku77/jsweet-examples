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
import java.util.HashSet;
import java.util.Set;

import Qnamic.Helper.StringUtils;

/**
 * @author catalin
 */
public class ServiceActivityDTO {
    private String id;
    private String activityId;
    private String legacyId;
    private String title;
    private String trainActivityTitle;
    private String from;
    private String to;
    private String begin;
    private String end;

    // RO-18721 New values from the edit
    private String fromNew;
    private String toNew;
    private String beginNew;
    private String endNew;
    private String serverState;

    private boolean bonusChanged; // if bonus values have been changed
    private BonusDTO[] bonuses;
    private boolean hasBonus;
    private boolean changeState;
    private boolean changeStateVehicle;

    private ActivityType type;
    private String processing;
    private String comment;
    private String trainId;
    private String trainNumber;
    private String person;
    private String area;
    private boolean editable;
    private boolean firstInSequence;
    private boolean lastInSequence;
    private boolean hasFunction;
    private String date;
    private RelatedResourceDTO[] personnelRelatedActivities;
    private RelatedResourceDTO[] vehicleRelatedActivities;
    private RelatedResourceDTO[] prevVehicleRelatedActivities;
    private RelatedResourceDTO[] prevVehicleStepRelatedActivities;
    private RelatedResourceDTO[] nextVehicleRelatedActivities;
    private RelatedResourceDTO[] nextVehicleStepRelatedActivities;

    private String[] prevTrainNumbers;
    private String[] prevTrainNumbersStep;
    private String[] nextTrainNumbers;
    private String[] nextTrainNumbersStep;
    private VehicleDTO[] formation;

    private String[] formationsAsString;

    private Attribute[] otherAttributes;

    private DocumentReferenceDTO[] linkedDocuments;

    private String linkToNext;

    private String linkToPrevious;

    // WISH-403

    private String debicode;

    private String projectNumber;

    // RO-18401 Stärken/Schwächen on From and To NetNode

    private String ccFromNodeValue;

    private String ccToNodeValue;

    public enum ActivityType {
        ACTIVITY_RUN,
        ACTIVITY_PRE,
        ACTIVITY_POST,
        ACTIVITY_NPA;

        boolean isRun() {
            return this == ActivityType.ACTIVITY_RUN;
        }

        boolean isNpa() {
            return this == ActivityType.ACTIVITY_NPA;
        }
    }

    public enum RelatedResourceFilterType {
        PREV_VEHICLE,
        PREV_VEHICLE_STEP,
        NEXT_VEHICLE,
        NEXT_VEHICLE_STEP
    }

    public ServiceActivityDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLegacyId() {
        return legacyId;
    }

    public void setLegacyId(String legacyId) {
        this.legacyId = legacyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTrainActivityTitle() {
        return trainActivityTitle;
    }

    public void setTrainActivityTitle(String trainActivityTitle) {
        this.trainActivityTitle = trainActivityTitle;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public boolean isChangeState() {
        return changeState;
    }

    public void setChangeState(boolean changeState) {
        this.changeState = changeState;
    }

    public boolean isChangeStateVehicle() {
        return changeStateVehicle;
    }

    public void setChangeStateVehicle(boolean changeStateVehicle) {
        this.changeStateVehicle = changeStateVehicle;
    }

    public ActivityType getType() {
        return type;
    }

    public void setType(ActivityType type) {
        this.type = type;
    }

    public String getProcessing() {
        return processing;
    }

    public void setProcessing(String processing) {
        this.processing = processing;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public Attribute[] getOtherAttributes() {
        return otherAttributes;
    }

    public void setOtherAttributes(Attribute[] otherAttributes) {
        this.otherAttributes = otherAttributes;
    }

    public RelatedResourceDTO[] getPersonnelRelatedActivities() {
        return personnelRelatedActivities;
    }

    public void setPersonnelRelatedActivities(RelatedResourceDTO[] personnelRelatedActivities) {
        this.personnelRelatedActivities = personnelRelatedActivities;
    }

    public RelatedResourceDTO[] getVehicleRelatedActivities() {
        return vehicleRelatedActivities;
    }

    public void setVehicleRelatedActivities(RelatedResourceDTO[] vehicleRelatedActivities) {
        this.vehicleRelatedActivities = vehicleRelatedActivities;
    }

    public VehicleDTO[] getFormation() {
        return formation;
    }

    public void setFormation(VehicleDTO[] formation) {
        this.formation = formation;
    }

    public boolean isFirstInSequence() {
        return firstInSequence;
    }

    public void setFirstInSequence(boolean firstInSequence) {
        this.firstInSequence = firstInSequence;
    }

    public boolean isLastInSequence() {
        return lastInSequence;
    }

    public void setLastInSequence(boolean lastInSequence) {
        this.lastInSequence = lastInSequence;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLinkToNext(String linkToNext) {
        this.linkToNext = linkToNext;
    }

    public String getLinkToNext() {
        return linkToNext;
    }

    public void setLinkToPrevious(String linkToPrevious) {
        this.linkToPrevious = linkToPrevious;
    }

    public RelatedResourceDTO[] getPrevVehicleRelatedActivities() {
        return prevVehicleRelatedActivities;
    }

    public void setPrevVehicleRelatedActivities(RelatedResourceDTO[] prevVehicleRelatedActivities) {
        this.prevVehicleRelatedActivities = prevVehicleRelatedActivities;
    }

    public void setPrevTrainNumbers(String[] prevTrainNumbers) {
        this.prevTrainNumbers = prevTrainNumbers;
    }

    public String[] getPrevTrainNumbers() {
        return prevTrainNumbers;
    }

    public RelatedResourceDTO[] getNextVehicleRelatedActivities() {
        return nextVehicleRelatedActivities;
    }

    public void setNextVehicleRelatedActivities(RelatedResourceDTO[] nextVehicleRelatedActivities) {
        this.nextVehicleRelatedActivities = nextVehicleRelatedActivities;
    }

    public String[] getNextTrainNumbers() {
        return nextTrainNumbers;
    }

    public void setNextTrainNumbers(String[] nextTrainNumbers) {
        this.nextTrainNumbers = nextTrainNumbers;
    }

    public String[] getPrevTrainNumbersStep() {
        return prevTrainNumbersStep;
    }

    public void setPrevTrainNumbersStep(String[] prevTrainNumbersStep) {
        this.prevTrainNumbersStep = prevTrainNumbersStep;
    }

    public String[] getNextTrainNumbersStep() {
        return nextTrainNumbersStep;
    }

    public void setNextTrainNumbersStep(String[] nextTrainNumbersStep) {
        this.nextTrainNumbersStep = nextTrainNumbersStep;
    }

    public RelatedResourceDTO[] getPrevVehicleStepRelatedActivities() {
        return prevVehicleStepRelatedActivities;
    }

    public void setPrevVehicleStepRelatedActivities(RelatedResourceDTO[] prevVehicleStepRelatedActivities) {
        this.prevVehicleStepRelatedActivities = prevVehicleStepRelatedActivities;
    }

    public RelatedResourceDTO[] getNextVehicleStepRelatedActivities() {
        return nextVehicleStepRelatedActivities;
    }

    public void setNextVehicleStepRelatedActivities(RelatedResourceDTO[] nextVehicleStepRelatedActivities) {
        this.nextVehicleStepRelatedActivities = nextVehicleStepRelatedActivities;
    }

    public String getLinkToPrevious() {
        return linkToPrevious;
    }

    public void setHasFunction(boolean hasFunction) {
        this.hasFunction = hasFunction;
    }

    public boolean isHasFunction() {
        return hasFunction;
    }

    //    (name ="singleInSequenceNonNPAOrIsRun") //TODO cd:
    public boolean isSingleInSequenceNonNPAOrIsRun() {
        return (firstInSequence && lastInSequence && !getType().isNpa()) || getType().isRun();
    }

    // TODO cd: (name ="driveTrain")
    public boolean driveTrain() {
        return !isHasFunction() && getType().isRun();
    }

    // helper methods
    //TODO cd: (name ="hasComment")

    public boolean hasComment() {
        return StringUtils.isNotEmpty(comment);
    }

    //TODO cd: (name ="headerTitle")

    public String getHeaderTitle() {
        switch (type) {
        case ACTIVITY_RUN:
        case ACTIVITY_PRE:
        case ACTIVITY_POST:
            return trainActivityTitle + " " + trainNumber;
        case ACTIVITY_NPA:
            return title;
        default:
            return "";
        }
    }

    //TODO cd: (name ="startLabel")
    public String getStartLabel() {
        switch (type) {
        case ACTIVITY_PRE:
        case ACTIVITY_POST:
        case ACTIVITY_NPA:
            //            return PersonnelReportingUIMessages.instance().get("personnelReportingNPADetailsBegin");
            // TODO cd:
        case ACTIVITY_RUN:
            //            return PersonnelReportingUIMessages.instance().get
            //            ("personnelReportingDetailsDepartureTime");
            // TODO cd:
        default:
            return "";
        }
    }

    //TODO cd: (name ="endLabel")
    public String endLabel() {
        switch (type) {
        case ACTIVITY_PRE:
        case ACTIVITY_POST:
        case ACTIVITY_NPA:
            //            return PersonnelReportingUIMessages.instance().get("personnelReportingNPADetailsEnd");
            //TODO cd:
        case ACTIVITY_RUN:
            //            return PersonnelReportingUIMessages.instance().get("personnelReportingDetailsArrivalTime");
            //TODO cd:
        default:
            return "";
        }
    }

    @Deprecated
    public RelatedResourceDTO[] filterNextVehicleResources(String trainNo) {
        return filter(nextVehicleRelatedActivities, trainNo);
    }

    @Deprecated
    public RelatedResourceDTO[] filterPreviousVehicleResources(String trainNo) {
        return filter(prevVehicleRelatedActivities, trainNo);
    }

    public RelatedResourceDTO[] getResourcesByType(String filterType) {
        final RelatedResourceFilterType filter = RelatedResourceFilterType.valueOf(filterType);
        switch (filter) {
        case PREV_VEHICLE:
            return prevVehicleRelatedActivities;
        case PREV_VEHICLE_STEP:
            return prevVehicleStepRelatedActivities;
        case NEXT_VEHICLE:
            return nextVehicleRelatedActivities;
        case NEXT_VEHICLE_STEP:
            return nextVehicleStepRelatedActivities;
        }
        return new RelatedResourceDTO[0];
    }

    public String getFirstDate(String filterType) {
        final RelatedResourceDTO[] resourcesByType = getResourcesByType(filterType);
        if (resourcesByType != null && resourcesByType.length > 0) {
            Arrays.sort(resourcesByType, (o1, o2) -> o1.getDate().compareTo(o2.getDate()));
            if (StringUtils.equals(getDate(), resourcesByType[0].getDate())) {
                return "";
            }
            return "(" + resourcesByType[0].getDate() + ")";
        }
        return "";
    }

    public RelatedResourceDTO[] getResourcesByTypeAndGroupByTrain(String filterType, String trainNo) {
        final RelatedResourceFilterType filter = RelatedResourceFilterType.valueOf(filterType);
        switch (filter) {
        case PREV_VEHICLE:
            return filter(prevVehicleRelatedActivities, trainNo);
        case PREV_VEHICLE_STEP:
            return filter(prevVehicleStepRelatedActivities, trainNo);
        case NEXT_VEHICLE:
            return filter(nextVehicleRelatedActivities, trainNo);
        case NEXT_VEHICLE_STEP:
            return filter(nextVehicleStepRelatedActivities, trainNo);
        }
        return new RelatedResourceDTO[0];
    }

    public String[] getTrainNumbers(String filterType) {
        final RelatedResourceFilterType filter = RelatedResourceFilterType.valueOf(filterType);
        switch (filter) {
        case PREV_VEHICLE:
            return prevTrainNumbers;
        case PREV_VEHICLE_STEP:
            return prevTrainNumbersStep;
        case NEXT_VEHICLE:
            return nextTrainNumbers;
        case NEXT_VEHICLE_STEP:
            return nextTrainNumbersStep;
        }
        return new String[0];
    }

    public DocumentReferenceDTO[] getLinkedDocumentsByTrain(String filterType, String trainNo) {
        final RelatedResourceFilterType filter = RelatedResourceFilterType.valueOf(filterType);
        switch (filter) {
        case PREV_VEHICLE:
            return getDocumentReferenceDTOS(filter(prevVehicleRelatedActivities, trainNo));
        case PREV_VEHICLE_STEP:
            return getDocumentReferenceDTOS(filter(prevVehicleStepRelatedActivities, trainNo));
        case NEXT_VEHICLE:
            return getDocumentReferenceDTOS(filter(nextVehicleRelatedActivities, trainNo));
        case NEXT_VEHICLE_STEP:
            return getDocumentReferenceDTOS(filter(nextVehicleStepRelatedActivities, trainNo));
        }
        return new DocumentReferenceDTO[0];
    }

    private DocumentReferenceDTO[] getDocumentReferenceDTOS(RelatedResourceDTO[] relatedResources) {
        Set<DocumentReferenceDTO> set = new HashSet<>();
        for (RelatedResourceDTO relatedResourceDTO : relatedResources) {
            set.addAll(Arrays.asList(relatedResourceDTO.getLinkedDocuments()));
        }
        return set.toArray(new DocumentReferenceDTO[0]);
    }

    private RelatedResourceDTO[] filter(RelatedResourceDTO[] resources, String trainNo) {
        return Arrays.stream(resources)
                .filter(r -> StringUtils.equals(r.getTrainNumber(), trainNo))
                .sorted((o1,o2)-> o1.getType().compareTo(o2.getType()))
                .toArray(value -> new RelatedResourceDTO[value]);
    }

    public String getDebicode() {
        return debicode;
    }

    public void setDebicode(String debicode) {
        this.debicode = debicode;
    }

    public String getCcFromNodeValue() {
        return ccFromNodeValue;
    }

    public void setCcFromNodeValue(String ccFromNodeValue) {
        this.ccFromNodeValue = valueToIcon(ccFromNodeValue);
    }

    public String getCcToNodeValue() {
        return ccToNodeValue;
    }

    public void setCcToNodeValue(String ccToNodeValue) {
        this.ccToNodeValue = valueToIcon(ccToNodeValue);
    }

    public String valueToIcon(String value) {
        // If the value is empty, then do not return any icon
        if (value == null) {
            return null;
        }

        if ("COUPLE".equals(value)) {
            return "y";
        }
        if ("DECOUPLE".equals(value)) {
            return "x";
        }
        return "z";
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    /**
     * Will have the format Vehicle.pool + " " + Vehicle.simpleName
     */
    public String[] getFormationsAsString() {
        return formationsAsString;
    }

    public void setFormationsAsString(String[] formationAsString) {
        this.formationsAsString = formationAsString;
    }

    public String getFromNew() {
        return fromNew;
    }

    public void setFromNew(String fromNew) {
        this.fromNew = fromNew;
    }

    public String getToNew() {
        return toNew;
    }

    public void setToNew(String toNew) {
        this.toNew = toNew;
    }

    public String getBeginNew() {
        return beginNew;
    }

    public void setBeginNew(String beginNew) {
        this.beginNew = beginNew;
    }

    public String getEndNew() {
        return endNew;
    }

    public void setEndNew(String endNew) {
        this.endNew = endNew;
    }

    public BonusDTO[] getBonuses() {
        return bonuses;
    }

    public void setBonuses(BonusDTO[] bonuses) {
        hasBonus = false;
        this.bonuses = bonuses;
        if (bonuses != null && bonuses.length > 0) {
            hasBonus = true;
        }
    }

    public DocumentReferenceDTO[] getLinkedDocuments() {
        return linkedDocuments;
    }

    public void setLinkedDocuments(DocumentReferenceDTO[] linkedDocuments) {
        this.linkedDocuments = linkedDocuments;
    }

    public boolean isHasBonus() {
        return hasBonus;
    }

    public void setHasBonusConfig() {
        hasBonus = true;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getServerState() {
        return serverState;
    }

    public void setServerState(String status) {
        this.serverState = status;
    }

    public boolean isBonusChanged() {
        return bonusChanged;
    }

    public void setBonusChanged(boolean bonusChanged) {
        this.bonusChanged = bonusChanged;
    }

}