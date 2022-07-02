package ca.dal.Group2.User.Repository;

import ca.dal.Group2.User.Entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Model, Long> {

    Model findByEmailId(String emailId);

}
