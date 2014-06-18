package ga.thesis.hibernate.service;

import ga.thesis.hibernate.entities.Period;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("periodRepository")
public interface PeriodRepository extends CrudRepository<Period, Long> {
}
