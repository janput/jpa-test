package org.example.jpa.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.util.Date;

/**
 * Common data for all entities that need to be audited. Audited means that we
 * store:
 * <ul>
 * <li>who created the entity and when</li>
 * <li>who modified the entity and when</li>
 * </ul>
 * <p>
 * Id's and version properties should be set in the concrete entities.
 *
 * @author philippe
 */
@Data
@MappedSuperclass
public abstract class AuditedModel {

    // Hibernate 4 does not yet support LocalDate and LocalDateTime so we use a
    // custom type. When we migrate to Hibernate 5 this won't be necessary
    // anymore
    // @see be.gamingcommission.licensing.persistence.hibernate.LocalDateTimeUserType

    @Column(name = "CREATEDDATE")
    private Date createdDate = new Date();

    @Column(name = "CREATEDBY")
    private String createdBy;

    @Column(name = "LASTMODDATE")
    private Date lastModDate;

    @Column(name = "LASTMODBY")
    private String lastModBy;

    @Transient
    public void touch(String userName) {
        if (createdBy == null) {
            createdBy = userName;
        }
        Date now = new Date();
        if (createdDate == null) {
            createdDate = now;
        }
        lastModDate = now;
        lastModBy = userName;
    }
}
