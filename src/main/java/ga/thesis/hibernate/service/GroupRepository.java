package ga.thesis.hibernate.service;

import ga.thesis.hibernate.entities.Group;
import ga.thesis.hibernate.entities.GroupList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("groupRepository")
public interface GroupRepository extends CrudRepository<Group, Long> {
}
