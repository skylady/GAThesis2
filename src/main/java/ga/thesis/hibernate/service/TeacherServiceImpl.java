package ga.thesis.hibernate.service;


import ga.thesis.hibernate.entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

@Repository
@Component("teacherService")
@Transactional
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    @Qualifier("teacherRepository")
    private TeacherRepository teacherRepository;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public Teacher findOne(long id) {
        return teacherRepository.findOne(id);
    }

    @Override
    public Iterable<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public void create(Teacher entity) {
        teacherRepository.save(entity);
    }

    @Override
    public Teacher update(Teacher entity) {
        return teacherRepository.save(entity);
    }

    @Override
    public void delete(Teacher entity) {
        teacherRepository.delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
        teacherRepository.delete(entityId);
    }
}
