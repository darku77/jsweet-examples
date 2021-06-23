// =============================================================================
// Copyright/Security Notice
//
// Licensed Materials - Property of Qnamic AG
// (C) Copyright Qnamic AG 2003-2021
// All rights reserved
//
// End Copyright
// =============================================================================
package PR.model.server.service.resources;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;

public class VehicleResourceDTO extends AbstractResourceDTO {

    private String name;
    private String type;
    private String typeName;
    private String serialNumber;
    private boolean element;
    private String reservationNumber;
    private List<VehicleDamageDTO> damages;

    @JsonCreator
    public VehicleResourceDTO() {
        set_TYPE(RESOURCE_VEHICLE);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean isElement() {
        return element;
    }

    public void setElement(boolean element) {
        this.element = element;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public List<VehicleDamageDTO> getDamages() {
        return damages;
    }

    public void setDamages(List<VehicleDamageDTO> damages) {
        this.damages = damages;
    }

    @Override
    public String toString() {
        return super.toString() + "@" + type + "@" + name;
    }
}