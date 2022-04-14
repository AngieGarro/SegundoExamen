package com.cenfotec.examen2.repositories;

import com.cenfotec.examen2.entities.PersonContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonContactRepository extends JpaRepository<PersonContact, Long> {
}
