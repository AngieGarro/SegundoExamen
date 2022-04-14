package com.cenfotec.examen2.service;

import com.cenfotec.examen2.entities.PersonContact;
import com.cenfotec.examen2.repositories.PersonContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonContactService {
    @Autowired
    PersonContactRepository personContactRepository;

    public void savePersona(PersonContact personContact){
        personContactRepository.save(personContact);
    }

    public List<PersonContact> getAll(){
        return personContactRepository.findAll();
    }

    public Optional<PersonContact> getById(int id) {
        return personContactRepository.findById(Long.valueOf(id));
    }

    public void updatePerson(PersonContact personContact) {
        personContactRepository.save(personContact);
    }

    public void deletePerson(int id) {
        personContactRepository.deleteById(Long.valueOf(id));
    }
}
