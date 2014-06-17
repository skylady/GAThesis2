package ga.thesis.hibernate.service;


import ga.thesis.hibernate.entities.AbsenceMatrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class AbsenceMatrixServiceImpl extends CRUDServiceImpl<AbsenceMatrix, Long> implements AbsenceMatrixService {

    @Autowired
    @Qualifier("absenceMatrixRepository")
    private AbsenceMatrixRepository absenceMatrixRepository;


    @Override
    protected CrudRepository<AbsenceMatrix, Long> getRepository() {
        return absenceMatrixRepository;
    }
}
