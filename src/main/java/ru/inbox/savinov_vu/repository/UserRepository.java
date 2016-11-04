package ru.inbox.savinov_vu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.inbox.savinov_vu.model.User;

/*@Transactional(readOnly = true)*/

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
