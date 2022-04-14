package com.cenfotec.examen2.repositories;

import com.cenfotec.examen2.entities.VistTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VistTrabajoRepository extends JpaRepository<VistTrabajo, Long> {
}
