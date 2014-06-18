package ga.thesis.hibernate.service;

import ga.thesis.hibernate.entities.GroupCode;
import ga.thesis.hibernate.entities.GroupList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("groupCodeRepository")
public interface GroupCodeRepository extends CrudRepository<GroupCode, Long> {
}
