package com.cenfotec.examen2.service;

import com.cenfotec.examen2.entities.Auditor;
import com.cenfotec.examen2.repositories.AuditorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuditorService {

    @Autowired
    AuditorRepository auditorRepository;

    public void saveAuditor(Auditor auditor){
       auditorRepository.save(auditor);
    }

    public List<Auditor> getAll(){
        return auditorRepository.findAll();
    }

    public Optional<Auditor> getById(int id) {
        return auditorRepository.findById(Long.valueOf(id));
    }


    public void updateAuditor(Auditor auditor) {
        auditorRepository.save(auditor);
    }
}
