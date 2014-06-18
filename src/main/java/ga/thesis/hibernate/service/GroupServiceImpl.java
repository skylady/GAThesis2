package ga.thesis.hibernate.service;


import ga.thesis.hibernate.entities.Group;
import ga.thesis.hibernate.entities.StudentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class GroupServiceImpl extends CRUDServiceImpl<Group, Long> implements GroupService {

    @Autowired
    @Qualifier("groupRepository")
    private GroupRepository groupRepository;


    @Override
    protected CrudRepository<Group, Long> getRepository() {
        return groupRepository;
    }
}
