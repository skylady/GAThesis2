package ga.thesis.hibernate.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by sky_lady on 6/14/14.
 */
@Entity
@Table(name = "Period")
public class Period implements Serializable {
    private static final long serialVersionUID = -5170875020617735654L; //?

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "period", nullable = false)
    private Integer period;

    @Column(name = "day_of_the_week", nullable = false)
    private String dayOfTheWeek;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }
}
