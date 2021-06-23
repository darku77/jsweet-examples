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

import com.fasterxml.jackson.annotation.JsonCreator;

public class PersonResourceDTO extends AbstractResourceDTO {

    private String name;
    private String personnelNumber;
    private String mobilePhone;

    @JsonCreator
    public PersonResourceDTO() {
        set_TYPE(RESOURCE_PERSON);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonnelNumber() {
        return personnelNumber;
    }

    public void setPersonnelNumber(String personnelNumber) {
        this.personnelNumber = personnelNumber;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    @Override
    public String toString() {
        return super.toString() + "@" + name;
    }
}
