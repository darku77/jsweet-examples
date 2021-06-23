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
 * @author catalin on 8/2/2017.
 */
public class VehicleDTO {

    private String uid;

    private String type;

    private String name;

    private String plainTextName;

    private String simpleName;

    private String pool;

    private VehicleDamageDTO[] damageDTOS;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public VehicleDamageDTO[] getDamageDTOS() {
        return damageDTOS;
    }

    public void setDamageDTOS(VehicleDamageDTO[] damageDTOS) {
        this.damageDTOS = damageDTOS;
    }

    public void setPlainTextName(String plainTextName) {
        this.plainTextName = plainTextName;
    }

    public String getPlainTextName() {
        return plainTextName;
    }

    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }

    /**
     * @author catalin
     */
    public interface VehicleType {
        String WAGON = "wagon";
        String ENGINE = "engine";
    }

    /**
     * @author catalin
     */
    public static class VehicleDamageDTO {

        private Attribute[] damages;

        public Attribute[] getDamages() {
            return damages;
        }

        public void setDamages(Attribute[] damages) {
            this.damages = damages;
        }
    }
}
