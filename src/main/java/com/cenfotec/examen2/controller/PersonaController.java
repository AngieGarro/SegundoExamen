package com.cenfotec.examen2.controller;

import com.cenfotec.examen2.entities.PersonContact;
import com.cenfotec.examen2.service.PersonContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class PersonaController {
    @Autowired
    PersonContactService personContactService;

    //Mantenimiento General de las personas de Contacto:
   @RequestMapping("/listarPersona")
    public String listarPersonas(Model model){
        List<PersonContact> results = personContactService.getAll();
        model.addAttribute("persona", personContactService.getAll());
        return "listarPersona";
    }

    @RequestMapping(value = "/agregarPersonaContact", method = RequestMethod.GET)
    public String InsertarPerson(Model model){
        model.addAttribute(new PersonContact());
        return "agregarPersonaContact";
    }

    @RequestMapping(value = "/agregarPersonaContact", method = RequestMethod.POST)
    public String AccionInsertarPerson(PersonContact personContact, BindingResult result, Model model){
        personContact.setCreated(Date.from(Instant.now()));
        personContactService.savePersona(personContact);
        return "Confirmacion";
    }

/**
    @RequestMapping(value = "/editar/{id}")
    public String EditarPerson(Model model, @PathVariable int id) {
        Optional<PersonContact> personContactToEdit = personContactService.getById(id);
        if (personContactToEdit.isPresent()){
            model.addAttribute("personContactToEdit", personContactToEdit);
            return "editFormPersonaContact";
        } else {
            return "notFound";
        }
    }

    @RequestMapping(value = "/editar/{id}", method = RequestMethod.POST)
    public String CambiosPerson(PersonContact personContact, BindingResult result,Model model,
                                @PathVariable int id) {
        personContact.setCreated(Date.from(Instant.now()));
        personContactService.updatePerson(personContact);
        return "Confirmacion";
    }

    @RequestMapping(value = "/borrar/{id}")
    public String deletePersona(Model model, @PathVariable int id) {
        personContactService.deletePerson(id);
        return "Confirmacion";
    }
 */

}
