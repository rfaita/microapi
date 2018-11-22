package com.training.microapi.test.helper;

import com.training.microapi.server.model.Cliente;

public class ClienteHelper {


    public static Cliente createBasicCliente(String nome, String email) {
        Cliente ret = new Cliente();
        ret.setEmail(email);
        ret.setNome(nome);
        return ret;
    }
}
