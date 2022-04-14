package com.cenfotec.examen2.service;

import com.cenfotec.examen2.entities.VistTrabajo;
import com.cenfotec.examen2.repositories.VistTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VistTrabajoService {
    @Autowired
    VistTrabajoRepository vistTrabajoRepository;

    public void saveVistas(VistTrabajo vistTrabajo){
        vistTrabajoRepository.save(vistTrabajo);
    }

    public List<VistTrabajo> getAll(){
        return vistTrabajoRepository.findAll();
    }

    public Optional<VistTrabajo> getById(int id) {
        return vistTrabajoRepository.findById(Long.valueOf(id));
    }

    public void updateVistas(VistTrabajo vistTrabajo) {
        vistTrabajoRepository.save(vistTrabajo);
    }

    public void deleteVistas(int id) {
        vistTrabajoRepository.deleteById(Long.valueOf(id));
    }
}
