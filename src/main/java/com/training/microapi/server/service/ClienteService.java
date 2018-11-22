package com.training.microapi.server.service;

import com.training.microapi.server.components.ClienteValidator;
import com.training.microapi.server.model.Cliente;
import com.training.microapi.server.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteValidator validator;

    public Cliente save(Cliente cliente) {

        validator.validate(cliente);

        return repository.save(cliente);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public void deleteAllByEmail(String email) {
        repository.deleteAllByEmail(email);
    }

    public Cliente findById(String id) {

        Optional<Cliente> ret = repository.findById(id);

        if (ret.isPresent()) {
            return ret.get();
        }
        return null;
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public List<Cliente> findAllByNomeLike(String nome) {
        return repository.findAllByNomeLike(nome);
    }

}
