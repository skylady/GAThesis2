package ga.thesis.hibernate.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sky_lady on 6/14/14.
 */
@Entity
@Table(name = "Auditory")
public class Auditory implements Serializable, HasId<Long> {
    private static final long serialVersionUID = -5170875020617735653L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "auditory_number", nullable = false)
    private String auditoryNumber;

    @Column(name = "auditory_size", nullable = false)
    private Integer auditorySize;

    @Column(name = "auditory_type", nullable = false)
    private String auditoryType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAuditorySize() {
        return auditorySize;
    }

    public void setAuditorySize(Integer auditorySize) {
        this.auditorySize = auditorySize;
    }

    public String getAuditoryNumber() {
        return auditoryNumber;
    }

    public void setAuditoryNumber(String auditoryNumber) {
        this.auditoryNumber = auditoryNumber;
    }

    public String getAuditoryType() {
        return auditoryType;
    }

    public void setAuditoryType(String auditoryType) {
        this.auditoryType = auditoryType;
    }

}
