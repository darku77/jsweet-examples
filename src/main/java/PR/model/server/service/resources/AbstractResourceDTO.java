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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "_TYPE")
@JsonSubTypes({@JsonSubTypes.Type(value = PersonResourceDTO.class, name = AbstractResourceDTO.RESOURCE_PERSON),
        @JsonSubTypes.Type(value = VehicleResourceDTO.class, name = AbstractResourceDTO.RESOURCE_VEHICLE)})
public abstract class AbstractResourceDTO {

    public static final String RESOURCE_PERSON = "RESOURCE_PERSON";
    public static final String RESOURCE_VEHICLE = "RESOURCE_VEHICLE";

    private String id;
    private String area;
    private String pool;
    private String _TYPE;

    public String get_TYPE() {
        return _TYPE;
    }

    public void set_TYPE(String _TYPE) {
        this._TYPE = _TYPE;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }

    public String getPool() {
        return pool;
    }

    @JsonIgnore
    public boolean isVehicleResourceTYPE() {
        return this._TYPE.equals(RESOURCE_VEHICLE);
    }

    @JsonIgnore
    public boolean isPersonResourceTYPE() {
        return this._TYPE.equals(RESOURCE_PERSON);
    }

    @Override
    public String toString() {
        return id + "@" + area + "@" + pool;
    }
}