package ga.thesis.hibernate.service;

import ga.thesis.hibernate.entities.GroupList;
import ga.thesis.hibernate.entities.StudentList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("groupListRepository")
public interface GroupListRepository extends CrudRepository<GroupList, Long> {
}
