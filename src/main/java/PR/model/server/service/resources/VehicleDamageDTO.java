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

import java.util.Arrays;
import java.util.List;

/**
 * @author catalin on 9/21/2018.
 */
public class VehicleDamageDTO {

    private List<VehicleDamageInfoDTO> damages;

    public List<VehicleDamageInfoDTO> getDamages() {
        return damages;
    }

    public void setDamages(List<VehicleDamageInfoDTO> damages) {
        this.damages = damages;
    }

    @Override
    public String toString() {
        return damages == null ? "null" : Arrays.toString(damages.toArray());
    }

    /**
     * @author catalin on 9/21/2018.
     */
    public static class VehicleDamageInfoDTO {

        private String infoIndicator;
        private String infoValue;

        public String getInfoIndicator() {
            return infoIndicator;
        }

        public void setInfoIndicator(String infoIndicator) {
            this.infoIndicator = infoIndicator;
        }

        public String getInfoValue() {
            return infoValue;
        }

        public void setInfoValue(String infoValue) {
            this.infoValue = infoValue;
        }

        @Override
        public String toString() {
            return infoIndicator + "/" + infoValue;
        }
    }
}
