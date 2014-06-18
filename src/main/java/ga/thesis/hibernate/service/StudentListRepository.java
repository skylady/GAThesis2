package ga.thesis.hibernate.service;

import ga.thesis.entities.Auditory;
import ga.thesis.hibernate.entities.StudentList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("studentListRepository")
public interface StudentListRepository extends CrudRepository<StudentList, Long> {
}
