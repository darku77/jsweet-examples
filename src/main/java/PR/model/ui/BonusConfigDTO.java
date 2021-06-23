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

/**
 * Holds the information about a configured bonus
 */
public class BonusConfigDTO {
    private String key;
    private Double minValue;
    private Double maxValue;
    private Double defaultValue;
    private Long decimalPlaces;

    public BonusConfigDTO(String key, Double minValue, Double maxValue, Double defaultValue, Long decimalPlaces) {
        this.key = key;
        this.minValue = minValue;
        this.decimalPlaces = decimalPlaces;
        this.maxValue = maxValue;
        this.defaultValue = defaultValue;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Double getMinValue() {
        return minValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    public Double getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Double defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Long getDecimalPlaces() {
        return decimalPlaces;
    }

    public void setDecimalPlaces(Long decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }
}
