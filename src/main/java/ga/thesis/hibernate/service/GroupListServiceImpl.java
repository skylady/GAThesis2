package ga.thesis.hibernate.service;


import ga.thesis.hibernate.entities.GroupList;
import ga.thesis.hibernate.entities.StudentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class GroupListServiceImpl extends CRUDServiceImpl<GroupList, Long> implements GroupListService {

    @Autowired
    @Qualifier("groupListRepository")
    private GroupListRepository groupListRepository;


    @Override
    protected CrudRepository<GroupList, Long> getRepository() {
        return groupListRepository;
    }
}
