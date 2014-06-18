package ga.thesis.hibernate.service;


import ga.thesis.hibernate.entities.Auditory;
import ga.thesis.hibernate.entities.StudentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class AuditoryServiceImpl extends CRUDServiceImpl<Auditory, Long> implements AuditoryService {

    @Autowired
    @Qualifier("auditoryRepository")
    private AuditoryRepository auditoryRepository;


    @Override
    protected CrudRepository<Auditory, Long> getRepository() {
        return auditoryRepository;
    }
}
