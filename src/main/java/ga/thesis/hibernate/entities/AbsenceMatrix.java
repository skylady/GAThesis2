package ga.thesis.hibernate.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sky_lady on 6/14/14.
 */
@Entity
@Table(name = "AbsenceMatrix")
public class AbsenceMatrix implements Serializable, HasId<Long> {
    private static final long serialVersionUID = -5170875020617735651L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "absenceMatrixName", nullable = false)
    private String absenceMatrixName;

    public String getAbsenceMatrixName() {
        return absenceMatrixName;
    }

    public void setAbsenceMatrixName(String absenceMatrixName) {
        this.absenceMatrixName = absenceMatrixName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
