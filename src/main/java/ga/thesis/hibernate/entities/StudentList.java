package ga.thesis.hibernate.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sky_lady on 6/14/14.
 */

@Entity
@Table(name="StudentList")
public class StudentList implements Serializable, HasId<Long> {
    private static final long serialVersionUID = -5170875020617735656L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column (name = "student_name",nullable=false)
    private String studentName;

    @ManyToOne
    @JoinColumn(name = "group_list_id")
    private GroupList idGroupList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public GroupList getIdGroupList() {
        return idGroupList;
    }

    public void setIdGroupList(GroupList idGroupList) {
        this.idGroupList = idGroupList;
    }
}
