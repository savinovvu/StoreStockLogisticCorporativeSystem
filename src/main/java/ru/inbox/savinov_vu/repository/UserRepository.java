package ru.inbox.savinov_vu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.inbox.savinov_vu.model.personal.User;

import java.util.List;

/*@Transactional(readOnly = true)*/

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.active=true")
    List<User> getAllActiveUser();
}
