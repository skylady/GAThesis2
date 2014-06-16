package ga.thesis.hibernate.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sky_lady on 6/14/14.
 */
@Entity
@Table(name = "AbsencePeriod")
public class AbsencePeriod implements Serializable {
    private static final long serialVersionUID = -5170875020617735659L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @OneToOne
    @JoinColumn(name = "period_id", nullable = false)
    private Period idPeriod;

    @OneToOne
    @JoinColumn(name = "absence_matrix_id", nullable = false)
    private AbsenceMatrix idAbsenceMatrix;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AbsenceMatrix getIdAbsenceMatrix() {
        return idAbsenceMatrix;
    }

    public void setIdAbsenceMatrix(AbsenceMatrix idAbsenceMatrix) {
        this.idAbsenceMatrix = idAbsenceMatrix;
    }

    public Period getIdPeriod() {
        return idPeriod;
    }

    public void setIdPeriod(Period idPeriod) {
        this.idPeriod = idPeriod;
    }
}


