package ga.thesis.hibernate.service;

import ga.thesis.hibernate.entities.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("teacherRepository")
public interface TeacherRepository extends CrudRepository<Teacher, Long> {
}
