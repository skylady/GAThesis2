package ga.thesis.hibernate.service;


import ga.thesis.hibernate.entities.AbsencePeriod;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AbsencePeriodServiceImpl extends CRUDServiceImpl<AbsencePeriod, Long> implements AbsencePeriodService {

    @Resource(name = "absencePeriodRepository")
    private AbsencePeriodRepository absencePeriodRepository;

    @Override
    protected CrudRepository<AbsencePeriod, Long> getRepository() {
        return absencePeriodRepository;
    }
}
