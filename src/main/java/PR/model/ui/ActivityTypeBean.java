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
 * This bean contains all important attributes of the activities to be shown for web users to add when editing services.
 * Some attributes such as: show or not the From/To fields (for Break activity), show Debicode, Project Number or not.
 * Further attributes can be added to this bean. All these attributes are retrieved from different RailOpt
 * configurations, not only from the Service Editing block, but also from the service/activity config.
 *
 * @author dvo
 *
 */
public class ActivityTypeBean {
    private int id = 0;

    private String activityKey;
    private String activityName;

    private boolean showFrom;
    private boolean showTo;

    private boolean hasDebicode;
    private boolean hasProjectNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActivityKey() {
        return activityKey;
    }

    public void setActivityKey(String activityKey) {
        this.activityKey = activityKey;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public boolean isShowFrom() {
        return showFrom;
    }

    public void setShowFrom(boolean showFrom) {
        this.showFrom = showFrom;
    }

    public boolean isShowTo() {
        return showTo;
    }

    public void setShowTo(boolean showTo) {
        this.showTo = showTo;
    }

    public boolean isHasDebicode() {
        return hasDebicode;
    }

    public void setHasDebicode(boolean hasDebicode) {
        this.hasDebicode = hasDebicode;
    }

    public boolean isHasProjectNumber() {
        return hasProjectNumber;
    }

    public void setHasProjectNumber(boolean hasProjectNumber) {
        this.hasProjectNumber = hasProjectNumber;
    }
}