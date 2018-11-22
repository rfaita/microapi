package com.training.microapi.server.resource;


import com.training.microapi.server.model.Cliente;
import com.training.microapi.server.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @PostMapping()
    public Cliente save(@RequestBody Cliente cliente) {
        return service.save(cliente);
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable String id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        service.deleteById(id);
    }

    @GetMapping()
    public List<Cliente> findAll() {
        return service.findAll();
    }

    @GetMapping("/findAllByNomeLike/{nome}")
    public List<Cliente> findAllByNomeLike(@PathVariable String nome) {
        return service.findAllByNomeLike(nome);
    }

    @DeleteMapping("/deleteAllByEmail/{email}")
    public void deleteAllByEmail(@PathVariable String email) {
        service.deleteAllByEmail(email);
    }

}
