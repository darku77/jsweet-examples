// =============================================================================
// Copyright/Security Notice
//
// Licensed Materials - Property of Qnamic AG
// (C) Copyright Qnamic AG 2003-2021
// All rights reserved
//
// End Copyright
// =============================================================================
package PR.model.server.service.sequence.activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import PR.model.server.changestate.ChangeStateDTO;
import PR.model.server.service.resources.AbstractResourceDTO;
import PR.model.server.service.resources.VehicleResourceDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "_TYPE")
@JsonSubTypes({@JsonSubTypes.Type(value = NPAActivityDTO.class, name = AbstractActivityDTO.ACTIVITY_TYPE_NPA),
        @JsonSubTypes.Type(value = TrainActivityDTO.class, name = AbstractActivityDTO.ACTIVITY_TYPE_TRAIN)})
public abstract class AbstractActivityDTO {

    public static final String ACTIVITY_TYPE_TRAIN = "ACTIVITY_TYPE_TRAIN";
    public static final String ACTIVITY_TYPE_NPA = "ACTIVITY_TYPE_NPA";

    public static final String IN_VERIFICATION = "IN_VERIFICATION";
    public static final String PENDING = "PENDING";
    public static final String REJECTED = "REJECTED";
    public static final String ACCEPTED = "ACCEPTED";
    public static final String OPEN = "OPEN";
    public static final String EMPTY = "";

    public enum RelationType {
        MULTI_TRACTION,
        PREV_VEHICLE_TRAIN_DRIVER,
        PREV_VEHICLE_TRAIN,
        PREV_VEHICLE_TRAIN_STEP,
        NEXT_VEHICLE_TRAIN_DRIVER,
        NEXT_VEHICLE_TRAIN,
        NEXT_VEHICLE_TRAIN_STEP
    }

    /**
     * Only in 2 states Open and Pending that users can open the dialog in Editable mode, otherwise readonly
     */
    public static boolean isEditable(String editState) {
        return EMPTY.equals(editState) || editState == null || OPEN.equals(editState);
    }

    public static class DocumentReference {
        private String docRefName;
        private String docRefRef;

        public String getDocRefName() {
            return docRefName;
        }

        public void setDocRefName(String docRefName) {
            this.docRefName = docRefName;
        }

        public String getDocRefRef() {
            return docRefRef;
        }

        public void setDocRefRef(String docRefRef) {
            this.docRefRef = docRefRef;
        }
    }

    public static class UIBonus {
        private String key;
        private String value;

        public UIBonus() {
        }

        @JsonIgnore
        public UIBonus(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class ActivityType {

        public static final String SERVICE_START = "SERVICE_START";
        public static final String SERVICE_END = "SERVICE_END";

        public static final String Pre = "Pre";
        public static final String Post = "Post";
        public static final String Step = "Step";

        public static final String In = "In";

        public static final String BREAK = "BREAK";
        public static final String SHORT_BREAK = "SHORT_BREAK";
        public static final String BREAK_PAID = "BREAK_PAID";

        public static final String WALK_TIME = "WALK_TIME";
        public static final String CA_VEHICLE_CONTROL = "CA_VEHICLE_CONTROL";
        public static final String RESERVATION = "RESERVATION";
        public static final String HOTEL_OVERNIGHT_STAY = "HOTEL_OVERNIGHT_STAY";
        public static final String CA_SHUNTING_TRIP = "CA_SHUNTING_TRIP";
        public static final String DEADHEAD_P = "DEADHEAD_P";
        public static final String TAXI = "TAXI";
        public static final String DP = "DP";
        public static final String COMMUTING = "COMMUTING";
        public static final String PREPROCESSING = "PREPROCESSING";

        private String translation;
        private String type;

        public String getTranslation() {
            return translation;
        }

        public void setTranslation(String translation) {
            this.translation = translation;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return type;
        }
    }

    private String _TYPE;
    private Date startDate;
    private String startTime;
    private Date endDate;
    private String endTime;

    /**
     * RO-18721 These attributes are for storing temporary values when editing the activity in FeatureServiceEdit mode
     */
    private Date startDateNew;
    private String startTimeNew;
    private Date endDateNew;
    private String endTimeNew;

    private String fromNew;
    private String toNew;

    private List<UIBonus> bonuses;

    private String id;
    private String activityId;
    private String baseServiceId;
    private String title;

    private String from;
    private String fromId;
    private String to;
    private String toId;

    private String realFrom;
    private String realTo;
    private String realStart;
    private String realEnd;

    private String comment;

    // request delay properties
    private String requestDelay;
    private String requestDelayEnd;

    /**
     * This state for Editing Service will be used as followed: "" = initial state, no change from Web. In this state
     * the value from the original service will be override to the Editing service, OPEN: If there is a change from Web,
     * IN_VERIFICATION: pending, ACCEPTED: If the Planer accepted the changes, and REJECTED: if the planer rejected the
     * changes
     */
    private String requestDelayState;
    private String requestDelayComment;

    private ActivityType type;
    private ChangeStateDTO changeStateDTO;
    private AbstractResourceDTO resource;
    private List<VehicleResourceDTO> formation;
    private Map<RelationType, List<AbstractActivityDTO>> relatedActivities = new HashMap<>();

    // pre/post process
    private String preProcessing;
    private String postProcessing;

    private boolean trainActivity;
    private boolean nonProductiveActivity;

    private List<DocumentReference> documentReferences = new ArrayList<>();

    // RO-18401 Stärken/Schwächen on From and To NetNode
    private String ccFromNodeValue;
    private String ccToNodeValue;

    public String get_TYPE() {
        return _TYPE;
    }

    public void set_TYPE(String _TYPE) {
        this._TYPE = _TYPE;
    }

    @JsonIgnore
    public boolean isActivityTYPETrain() {
        return this._TYPE.equals(ACTIVITY_TYPE_TRAIN);
    }

    @JsonIgnore
    public boolean isActivityTYPENPA() {
        return this._TYPE.equals(ACTIVITY_TYPE_NPA);
    }

    @JsonIgnore
    public List<AbstractActivityDTO> getRelatedMultiTraction() {
        return relatedActivities.get(RelationType.MULTI_TRACTION);
    }

    @JsonIgnore
    public List<AbstractActivityDTO> getPrevVehicleTrain() {
        return relatedActivities.get(RelationType.PREV_VEHICLE_TRAIN);
    }

    @JsonIgnore
    public List<AbstractActivityDTO> getPrevVehicleTrainDriver() {
        return relatedActivities.get(RelationType.PREV_VEHICLE_TRAIN_DRIVER);
    }

    @JsonIgnore
    public List<AbstractActivityDTO> getNextVehicleTrain() {
        return relatedActivities.get(RelationType.NEXT_VEHICLE_TRAIN);
    }

    @JsonIgnore
    public List<AbstractActivityDTO> getNextVehicleTrainDriver() {
        return relatedActivities.get(RelationType.NEXT_VEHICLE_TRAIN_DRIVER);
    }

    @JsonIgnore
    public List<AbstractActivityDTO> getNextVehicleTrainStep() {
        return relatedActivities.get(RelationType.NEXT_VEHICLE_TRAIN_STEP);
    }

    @JsonIgnore
    public List<AbstractActivityDTO> getPrevVehicleTrainStep() {
        return relatedActivities.get(RelationType.PREV_VEHICLE_TRAIN_STEP);
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getRequestDelay() {
        return requestDelay;
    }

    public void setRequestDelay(String requestDelay) {
        this.requestDelay = requestDelay;
    }

    public String getRequestDelayState() {
        return requestDelayState;
    }

    public void setRequestDelayState(String requestDelayState) {
        this.requestDelayState = requestDelayState;
    }

    public String getRequestDelayComment() {
        return requestDelayComment;
    }

    public void setRequestDelayComment(String requestDelayComment) {
        this.requestDelayComment = requestDelayComment;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getBaseServiceId() {
        return baseServiceId;
    }

    public void setBaseServiceId(String baseServiceId) {
        this.baseServiceId = baseServiceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ActivityType getType() {
        return type;
    }

    public void setType(ActivityType type) {
        this.type = type;
    }

    public ChangeStateDTO getChangeStateDTO() {
        return changeStateDTO;
    }

    public void setChangeStateDTO(ChangeStateDTO changeStateDTO) {
        this.changeStateDTO = changeStateDTO;
    }

    public String getPreProcessing() {
        return preProcessing;
    }

    public void setPreProcessing(String preProcessing) {
        this.preProcessing = preProcessing;
    }

    public String getPostProcessing() {
        return postProcessing;
    }

    public void setPostProcessing(String postProcessing) {
        this.postProcessing = postProcessing;
    }

    public boolean isTrainActivity() {
        return trainActivity;
    }

    public void setTrainActivity(boolean trainActivity) {
        this.trainActivity = trainActivity;
    }

    public boolean isNonProductiveActivity() {
        return nonProductiveActivity;
    }

    public void setNonProductiveActivity(boolean nonProductiveActivity) {
        this.nonProductiveActivity = nonProductiveActivity;
    }

    public AbstractResourceDTO getResource() {
        return resource;
    }

    public void setResource(AbstractResourceDTO resource) {
        this.resource = resource;
    }

    public Map<RelationType, List<AbstractActivityDTO>> getRelatedActivities() {
        return relatedActivities;
    }

    public void setRelatedActivities(Map<RelationType, List<AbstractActivityDTO>> relatedActivities) {
        this.relatedActivities = relatedActivities;
    }

    public List<DocumentReference> getDocumentReferences() {
        return documentReferences;
    }

    public void setDocumentReferences(List<DocumentReference> documentReferences) {
        this.documentReferences = documentReferences;
    }

    public List<VehicleResourceDTO> getFormation() {
        return formation;
    }

    public void setFormation(List<VehicleResourceDTO> formation) {
        this.formation = formation;
    }

    public String getCcToNodeValue() {
        return ccToNodeValue;
    }

    public void setCcToNodeValue(String ccToNodeValue) {
        this.ccToNodeValue = ccToNodeValue;
    }

    public String getCcFromNodeValue() {
        return ccFromNodeValue;
    }

    public void setCcFromNodeValue(String ccFromNodeValue) {
        this.ccFromNodeValue = ccFromNodeValue;
    }

    public String getRequestDelayEnd() {
        return requestDelayEnd;
    }

    public void setRequestDelayEnd(String requestDelayEnd) {
        this.requestDelayEnd = requestDelayEnd;
    }

    public String getRealFrom() {
        return realFrom;
    }

    public void setRealFrom(String realFrom) {
        this.realFrom = realFrom;
    }

    public String getRealTo() {
        return realTo;
    }

    public void setRealTo(String realTo) {
        this.realTo = realTo;
    }

    public String getRealStart() {
        return realStart;
    }

    public void setRealStart(String realStart) {
        this.realStart = realStart;
    }

    public String getRealEnd() {
        return realEnd;
    }

    public void setRealEnd(String realEnd) {
        this.realEnd = realEnd;
    }

    public Date getStartDateNew() {
        return startDateNew;
    }

    public void setStartDateNew(Date startDateNew) {
        this.startDateNew = startDateNew;
    }

    public String getStartTimeNew() {
        return startTimeNew;
    }

    public void setStartTimeNew(String startTimeNew) {
        this.startTimeNew = startTimeNew;
    }

    public Date getEndDateNew() {
        return endDateNew;
    }

    public void setEndDateNew(Date endDateNew) {
        this.endDateNew = endDateNew;
    }

    public String getEndTimeNew() {
        return endTimeNew;
    }

    public void setEndTimeNew(String endTimeNew) {
        this.endTimeNew = endTimeNew;
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

    @JsonIgnore
    public boolean hasBonus() {
        if (bonuses == null || bonuses.size() == 0) {
            return false;
        }
        return true;
    }

    @JsonIgnore
    public void addBonus(UIBonus bonus) {
        if (bonuses == null) {
            bonuses = new ArrayList<>();
        }
        bonuses.add(bonus);
    }

    public void setBonuses(List<UIBonus> bonuses) {
        this.bonuses = bonuses;
    }

    public List<UIBonus> getBonuses() {
        return bonuses;
    }

    @Override
    public String toString() {
        return type.toString() + "@" + id;
    }
}