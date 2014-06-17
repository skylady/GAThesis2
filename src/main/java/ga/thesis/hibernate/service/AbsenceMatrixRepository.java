package ga.thesis.hibernate.service;

import ga.thesis.hibernate.entities.AbsenceMatrix;
import ga.thesis.hibernate.entities.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("absenceMatrixRepository")
public interface AbsenceMatrixRepository extends CrudRepository<AbsenceMatrix, Long> {
}
