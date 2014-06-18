package ga.thesis.hibernate.service;


import ga.thesis.hibernate.entities.GroupCode;
import ga.thesis.hibernate.entities.StudentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class GroupCodeServiceImpl extends CRUDServiceImpl<GroupCode, Long> implements GroupCodeService {

    @Autowired
    @Qualifier("groupCodeRepository")
    private GroupCodeRepository groupCodeRepository;


    @Override
    protected CrudRepository<GroupCode, Long> getRepository() {
        return groupCodeRepository;
    }
}
