package ga.thesis.hibernate.service;


import ga.thesis.hibernate.entities.AbsenceMatrix;
import ga.thesis.hibernate.entities.StudentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentListServiceImpl extends CRUDServiceImpl<StudentList, Long> implements StudentListService {

    @Autowired
    @Qualifier("studentListRepository")
    private StudentListRepository studentListRepository;


    @Override
    protected CrudRepository<StudentList, Long> getRepository() {
        return studentListRepository;
    }
}
