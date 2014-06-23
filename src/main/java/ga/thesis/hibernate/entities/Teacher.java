package ga.thesis.hibernate.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sky_lady on 6/14/14.
 */
@Entity
@Table(name = "Teacher")
public class Teacher implements Serializable, HasId<Long> {
    private static final long serialVersionUID = -5170875020617735673L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "id_absence_matrix", nullable = true)
    private AbsenceMatrix idAbsenceMatrix;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AbsenceMatrix getIdAbsenceMatrix() {
        return idAbsenceMatrix;
    }

    public void setIdAbsenceMatrix(AbsenceMatrix idAbsenceMatrix) {
        this.idAbsenceMatrix = idAbsenceMatrix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
