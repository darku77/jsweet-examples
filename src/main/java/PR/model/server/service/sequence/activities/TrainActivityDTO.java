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

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author catalin on 8/8/2017.
 */
public class TrainActivityDTO extends AbstractActivityDTO {

    @JsonCreator
    public TrainActivityDTO() {
        set_TYPE(ACTIVITY_TYPE_TRAIN);
    }

    public static class FunctionDTO {

        private String code;
        private String description;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return code;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            FunctionDTO that = (FunctionDTO) o;
            return code.equals(that.code);
        }

        @Override
        public int hashCode() {
            return Objects.hash(code);
        }
    }

    public static class AdditionalRoleDTO {

        private String code;
        private String description;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return code;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            AdditionalRoleDTO that = (AdditionalRoleDTO) o;
            return code.equals(that.code);
        }

        @Override
        public int hashCode() {
            return Objects.hash(code);
        }
    }

    private String trainId;
    private String trainNumber;
    private String tractionType;
    private String trainDate;

    private boolean trainRunActivity;
    private boolean preProcessActivity;
    private boolean postProcessActivity;

    private FunctionDTO functionDTO;
    private List<AdditionalRoleDTO> additionalRoles;

    // split trains
    private boolean withSplitTrains;
    private boolean productive;
    private boolean closed;
    private List<String> splitTrains;
    // will return either split trains if there are more or just only the train id
    private List<String> trainNumbers;

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTractionType() {
        return tractionType;
    }

    public void setTractionType(String tractionType) {
        this.tractionType = tractionType;
    }

    public String getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(String trainDate) {
        this.trainDate = trainDate;
    }

    public boolean isTrainRunActivity() {
        return trainRunActivity;
    }

    public void setTrainRunActivity(boolean trainRunActivity) {
        this.trainRunActivity = trainRunActivity;
    }

    public boolean isPreProcessActivity() {
        return preProcessActivity;
    }

    public void setPreProcessActivity(boolean preProcessActivity) {
        this.preProcessActivity = preProcessActivity;
    }

    public boolean isPostProcessActivity() {
        return postProcessActivity;
    }

    public void setPostProcessActivity(boolean postProcessActivity) {
        this.postProcessActivity = postProcessActivity;
    }

    public FunctionDTO getFunctionDTO() {
        return functionDTO;
    }

    public void setFunctionDTO(FunctionDTO functionDTO) {
        this.functionDTO = functionDTO;
    }

    public List<AdditionalRoleDTO> getAdditionalRoles() {
        return additionalRoles;
    }

    public void setAdditionalRoles(List<AdditionalRoleDTO> additionalRoles) {
        this.additionalRoles = additionalRoles;
    }

    public boolean isWithSplitTrains() {
        return withSplitTrains;
    }

    public void setWithSplitTrains(boolean withSplitTrains) {
        this.withSplitTrains = withSplitTrains;
    }

    public boolean isProductive() {
        return productive;
    }

    public void setProductive(boolean productive) {
        this.productive = productive;
    }

    public List<String> getSplitTrains() {
        return splitTrains;
    }

    public void setSplitTrains(List<String> splitTrains) {
        this.splitTrains = splitTrains;
    }

    public List<String> getTrainNumbers() {
        return trainNumbers;
    }

    public void setTrainNumbers(List<String> trainNumbers) {
        this.trainNumbers = trainNumbers;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public boolean isClosed() {
        return closed;
    }

    @JsonIgnore
    public boolean hasTrains() {
        return (trainNumbers != null && !trainNumbers.isEmpty());
    }

    @Override
    public String toString() {
        return super.toString() + "@" + trainNumber;
    }
}