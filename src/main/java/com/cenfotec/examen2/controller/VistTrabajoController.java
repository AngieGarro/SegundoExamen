package com.cenfotec.examen2.controller;

import com.cenfotec.examen2.entities.Cliente;
import com.cenfotec.examen2.entities.PersonContact;
import com.cenfotec.examen2.entities.VistTrabajo;
import com.cenfotec.examen2.service.VistTrabajoService;
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
public class VistTrabajoController {
    @Autowired
    VistTrabajoService trabajoService;


    @RequestMapping("/verVistas")
    public String listarVisitas(Model model){
        List<VistTrabajo> results = trabajoService.getAll();
        model.addAttribute("trabajo", trabajoService.getAll());
        return "verVistas";
    }

    @RequestMapping(value = "/agregarTrabajo", method = RequestMethod.GET)
    public String navegarPaginaTrabajo(Model model){
        model.addAttribute(new VistTrabajo());
        return "agregarTrabajo";
    }

    @RequestMapping(value = "/agregarTrabajo", method = RequestMethod.POST)
    public String accionInsertarTrabajo(VistTrabajo vistTrabajo, BindingResult result, Model model){
        vistTrabajo.setCreated(Date.from(Instant.now()));
        trabajoService.saveVistas(vistTrabajo);
        return "Confirmacion";
    }

/**
    @RequestMapping(value = "/editar/{id}")
    public String irAEditar(Model model, @PathVariable int id) {
        Optional<VistTrabajo> trabajoToEdit = trabajoService.getById(id);
        if (trabajoToEdit.isPresent()){
            model.addAttribute("trabajoToEdit", trabajoToEdit);
            return "editFormTrabajo"; //Falta HTML
        } else {
            return "notFound";
        }
    }

    @RequestMapping(value = "/editar/{id}", method = RequestMethod.POST)
    public String guardarCambios(VistTrabajo trabajo, BindingResult result,Model model,
                                 @PathVariable int id) {
        trabajo.setCreated(Date.from(Instant.now()));
        trabajoService.updateVistas(trabajo);
        return "Confirmacion";
    }

    @RequestMapping(value = "/borrar/{id}")
    public String borrar(Model model, @PathVariable int id) {
        trabajoService.deleteVistas(id);
        return "Confirmacion";
    }
    */
}
