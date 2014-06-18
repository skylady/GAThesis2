package ga.thesis.hibernate.service;


import ga.thesis.hibernate.entities.Period;
import ga.thesis.hibernate.entities.StudentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class PeriodServiceImpl extends CRUDServiceImpl<Period, Long> implements PeriodService {

    @Autowired
    @Qualifier("periodRepository")
    private PeriodRepository periodRepository;


    @Override
    protected CrudRepository<Period, Long> getRepository() {
        return periodRepository;
    }
}
