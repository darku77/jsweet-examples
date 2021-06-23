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

import java.util.Objects;

/**
 * @author Catalin on 7/30/2020
 */
public class DocumentReferenceDTO {
    private String docRefName;
    private String docRefRef;

    public String getDocRefName() {
        return docRefName;
    }

    public void setDocRefName(String docRefName) {
        this.docRefName = docRefName;
    }

    public String getDocRefRef() {
        return docRefRef;
    }

    public void setDocRefRef(String docRefRef) {
        this.docRefRef = docRefRef;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DocumentReferenceDTO that = (DocumentReferenceDTO) o;
        return Objects.equals(docRefName, that.docRefName) && Objects.equals(docRefRef, that.docRefRef);
    }

    @Override
    public int hashCode() {
        return Objects.hash(docRefName, docRefRef);
    }
}
