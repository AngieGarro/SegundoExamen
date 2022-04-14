package com.cenfotec.examen2.controller;

import com.cenfotec.examen2.entities.Auditor;
import com.cenfotec.examen2.service.AuditorService;
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
public class AuditorController {
    @Autowired
    AuditorService auditorService;

    @RequestMapping("/")
    public String index(Model model){
        return "index";
    }

    @RequestMapping("/verAuditores")
    public String listarAuditores(Model model){
        List<Auditor> results = auditorService.getAll();
        model.addAttribute("auditor", auditorService.getAll());
        return "verAuditores";
    }

    @RequestMapping(value = "/agregarAuditor", method = RequestMethod.GET)
    public String navegarPaginaInsertar(Model model){
        model.addAttribute(new Auditor());
        return "agregarAuditor";
    }

    @RequestMapping(value = "/agregarAuditor", method = RequestMethod.POST)
    public String accionPaginaInsertar(Auditor auditor, BindingResult result, Model model){
        auditor.setCreated(Date.from(Instant.now()));
        auditorService.saveAuditor(auditor);
        return "Confirmacion";
    }

    @RequestMapping(value = "/editar/{id}")
    public String irAEditar(Model model, @PathVariable int id) {
        Optional<Auditor> auditorToEdit = auditorService.getById(id);
        if (auditorToEdit.isPresent()){
            model.addAttribute("auditorToEdit", auditorToEdit);
            return "editFormAuditor";
        } else{
            return "notFound";
        }
    }
    @RequestMapping(value = "/editar/{id}", method = RequestMethod.POST)
    public String guardarCambios(Auditor auditor, BindingResult result,Model model,
                                 @PathVariable int id) {
        auditor.setCreated(Date.from(Instant.now()));
        auditorService.updateAuditor(auditor);
        return "Confirmacion";
    }
}
