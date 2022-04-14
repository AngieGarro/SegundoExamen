package com.cenfotec.examen2.repositories;

import com.cenfotec.examen2.entities.Auditor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditorRepository extends JpaRepository<Auditor, Long> {

}
