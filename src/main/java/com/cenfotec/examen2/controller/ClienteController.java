package com.cenfotec.examen2.controller;

import com.cenfotec.examen2.entities.Cliente;
import com.cenfotec.examen2.entities.PersonContact;
import com.cenfotec.examen2.service.ClienteService;
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
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    //Mantenimiento General de los clientes:
    @RequestMapping("/VerClientes")
    public String listarClientes(Model model){
        List<Cliente> resultsC = clienteService.getAll();
        model.addAttribute("cliente", clienteService.getAll());
        return "VerClientes";
    }

    @RequestMapping(value = "/agregarClientes", method = RequestMethod.GET)
    public String InsertarCliente(Model model){
        model.addAttribute(new Cliente());
        return "agregarClientes";
    }

    @RequestMapping(value = "/agregarClientes", method = RequestMethod.POST)
    public String accionInsertarClientes(Cliente cliente, BindingResult result, Model model){
        cliente.setCreated(Date.from(Instant.now()));
        clienteService.saveCliente(cliente);
        return "Confirmacion";
    }
    /**
    @RequestMapping(value = "/editar/{id}")
    public String EditCliente(Model model, @PathVariable int id){
        Optional<Cliente> clienteToEdit = clienteService.getById(id);
        if (clienteToEdit.isPresent()){
            return "editFormCliente";
        }else{
            return "notFound";
        }
    }

    @RequestMapping(value = "/editar/{id}", method = RequestMethod.POST)
    public String CambiosCliente(Cliente cliente, BindingResult result,Model model,
                                 @PathVariable int id) {
        cliente.setCreated(Date.from(Instant.now()));
        clienteService.updateCliente(cliente);
        return "Confirmacion";
    }
     */

    @RequestMapping(value = "/borrar/{id}")
    public String deleteCliente(Model model, @PathVariable int id) {
        clienteService.deleteCliente(id);
        return "Confirmacion";
    }


}
