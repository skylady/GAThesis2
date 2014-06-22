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

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "groupSize", nullable = false)
    private Integer groupSize;

    public Integer getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(Integer groupSize) {
        this.groupSize = groupSize;
    }

    @Column(name = "subject_type", nullable = false)
    private String subjectType;

    @Column(name = "week_numbers", nullable = false)
    private String weekNumbers;

    @Column(name = "group_type", nullable = false)
    private String groupType;

    @OneToOne
    @JoinColumn(name = "group_list_id")
    private GroupList idGroupList;

    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Teacher idGroupTeacher;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public GroupList getIdGroupList() {
        return idGroupList;
    }

    public void setIdGroupList(GroupList idGroupList) {
        this.idGroupList = idGroupList;
    }

    public String getWeekNumbers() {
        return weekNumbers;
    }

    public void setWeekNumbers(String weekNumbers) {
        this.weekNumbers = weekNumbers;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public Teacher getIdGroupTeacher() {
        return idGroupTeacher;
    }

    public void setIdGroupTeacher(Teacher idGroupTeacher) {
        this.idGroupTeacher = idGroupTeacher;
    }
}
