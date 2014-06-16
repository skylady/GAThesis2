package ga.thesis.hibernate.service;


import ga.thesis.hibernate.entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component("teacherService")
@Transactional
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

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
