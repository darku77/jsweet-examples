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
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * @author catalin on 8/8/2017.
 */
public class NPAActivityDTO extends AbstractActivityDTO {

    @JsonCreator
    public NPAActivityDTO() {
        set_TYPE(ACTIVITY_TYPE_NPA);
    }

    private String hotelOvernight;
    private String hotelOvernightBookingStatus;
    private String hotelOvernightBookingNumber;

    public String getHotelOvernight() {
        return hotelOvernight;
    }

    public void setHotelOvernight(String hotelOvernight) {
        this.hotelOvernight = hotelOvernight;
    }

    public String getHotelOvernightBookingStatus() {
        return hotelOvernightBookingStatus;
    }

    public void setHotelOvernightBookingStatus(String hotelOvernightBookingStatus) {
        this.hotelOvernightBookingStatus = hotelOvernightBookingStatus;
    }

    public String getHotelOvernightBookingNumber() {
        return hotelOvernightBookingNumber;
    }

    public void setHotelOvernightBookingNumber(String hotelOvernightBookingNumber) {
        this.hotelOvernightBookingNumber = hotelOvernightBookingNumber;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
