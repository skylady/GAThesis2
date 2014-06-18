package ga.thesis.hibernate.service;


import ga.thesis.hibernate.entities.AbsenceMatrix;
import ga.thesis.hibernate.entities.Auditory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("auditoryRepository")
public interface AuditoryRepository extends CrudRepository<Auditory, Long> {
}
