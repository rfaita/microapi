package com.training.microapi.server.repository;

import com.training.microapi.server.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {

    void deleteAllByEmail(String email);

    List<Cliente> findAllByNomeLike(String nome);

}
