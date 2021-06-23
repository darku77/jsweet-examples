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

import static PR.model.ui.RelatedResourceDTO.RelatedResourceType.PERSON;

/**
 * @author catalin
 */
public class RelatedResourceDTO {
    
    private String id;
    private String title;
    private String date;
    private String type;
    private String resource;
    private String phone;
    private String from;
    private String to;
    private String begin;
    private String end;
    private String area;
    private String trainNumber;
    private boolean isClosed = false;
    private DocumentReferenceDTO[] linkedDocuments;
    private String realFrom;
    private String realTo;
    private String realStart;
    private String realEnd;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(boolean isClosed) {
        this.isClosed = isClosed;
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

    public DocumentReferenceDTO[] getLinkedDocuments() {
        return linkedDocuments;
    }

    public void setLinkedDocuments(DocumentReferenceDTO[] linkedDocuments) {
        this.linkedDocuments = linkedDocuments;
    }

    //TODO cd: check name here
    public String getIcon() {
        if (PERSON.equals(type)) {
            return "social:person";
        }

        if (isClosed) {
            // RO-18401: for überfuhr service, if we have another icon then no need to use template if in html
            // return "maps:railwayxxxxxxxxxx"; // find another icon
        }
        return "maps:directions-railway";
    }

    //TODO cd: check name here
    public String getPhoneIcon() {
        if (PERSON.equals(type)) {
            return "communication:phone";
        }
        return "";

    }

    @Override
    public String toString() {
        return "{ \"title\":" + (title == null ? "null" : "\"" + title + "\"") + ", " + "\"resource\":"
                + (resource == null ? "null" : "\"" + resource + "\"") + ", " + "\"train\":"
                + (trainNumber == null ? "null" : "\"" + trainNumber + "\"") + "}";
    }

    /**
     * @author catalin
     */
    public interface RelatedResourceType {
        String PERSON = "PERSON";
        String VEHICLE = "VEHICLE";
    }
}