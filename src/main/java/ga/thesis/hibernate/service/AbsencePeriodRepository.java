package ga.thesis.hibernate.service;


import ga.thesis.hibernate.entities.AbsencePeriod;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("absencePeriodRepository")
public interface AbsencePeriodRepository extends CrudRepository<AbsencePeriod, Long> {
}
