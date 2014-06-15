package ga.thesis.hibernate.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sky_lady on 6/14/14.
 */
@Entity
@Table(name = "GroupCode")
public class GroupCode implements Serializable {

    private static final long serialVersionUID = -5170875020617735693L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "course", nullable = false)
    private String course;

    @Column(name = "subject", nullable = false)
    private Integer subject;

    @Column(name = "subject_type", nullable = false)
    private String subjectType;

    @Column(name = "week_numbers", nullable = false)
    private String weekNumbers;

    @Column(name = "group_type", nullable = false)
    private Integer groupType;

    @OneToOne
    @JoinColumn(name = "group_list_id")
    private GroupCode idGroupList;

    @OneToOne
    @JoinColumn(name = "teacher_id")
    private GroupCode idGroupTeacher;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public GroupCode getIdGroupList() {
        return idGroupList;
    }

    public void setIdGroupList(GroupCode idGroupList) {
        this.idGroupList = idGroupList;
    }

    public String getWeekNumbers() {
        return weekNumbers;
    }

    public void setWeekNumbers(String weekNumbers) {
        this.weekNumbers = weekNumbers;
    }

    public Integer getSubject() {
        return subject;
    }

    public void setSubject(Integer subject) {
        this.subject = subject;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public Integer getGroupType() {
        return groupType;
    }

    public void setGroupType(Integer groupType) {
        this.groupType = groupType;
    }

    public GroupCode getIdGroupTeacher() {
        return idGroupTeacher;
    }

    public void setIdGroupTeacher(GroupCode idGroupTeacher) {
        this.idGroupTeacher = idGroupTeacher;
    }
}
