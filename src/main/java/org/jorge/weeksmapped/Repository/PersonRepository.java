package org.jorge.weeksmapped.Repository;

import org.jorge.weeksmapped.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    boolean existsByUser(String user);
}
