package ga.thesis.hibernate.service;


import ga.thesis.hibernate.entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class TeacherServiceImpl extends CRUDServiceImpl<Teacher, Long> implements TeacherService {

    @Autowired
    @Qualifier("teacherRepository")
    private TeacherRepository teacherRepository;

    @Override
    protected CrudRepository<Teacher, Long> getRepository() {
        return teacherRepository;
    }
}
