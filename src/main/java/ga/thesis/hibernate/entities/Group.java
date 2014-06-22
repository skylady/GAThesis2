package ga.thesis.hibernate.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sky_lady on 6/14/14.
 */
@Entity
@Table(name = "`Group`")
public class Group implements Serializable{
    private static final long serialVersionUID = -5170875020617735673L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "group_number", nullable = false)
    private Integer groupNumber;

    @OneToOne
    @JoinColumn(name = "group_code_id",nullable = false)
    private GroupCode idGroupCode;


    @Column(name = "course", nullable = false)
    private String course;

    public GroupCode getIdGroupCode() {
        return idGroupCode;
    }

    public void setIdGroupCode(GroupCode idGroupCode) {
        this.idGroupCode = idGroupCode;
    }

    public Integer getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
