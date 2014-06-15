package ga.thesis.hibernate.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sky_lady on 6/14/14.
 */

@Entity
@Table(name="StudentList")
public class StudentList implements Serializable {
    private static final long serialVersionUID = -5170875020617735656L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column (name = "student_name",nullable=false)
    private String studentName;

    @ManyToOne
    @JoinColumn(name = "group_list_id")
    private GroupList idGroupList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
