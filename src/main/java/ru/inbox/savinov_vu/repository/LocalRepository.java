package ru.inbox.savinov_vu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.inbox.savinov_vu.model.local.LocalStorage;

@Repository
public interface LocalRepository extends JpaRepository<LocalStorage, Integer> {
}
