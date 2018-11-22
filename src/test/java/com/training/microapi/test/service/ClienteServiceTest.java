package com.training.microapi.test.service;

import com.training.microapi.server.components.ClienteValidator;
import com.training.microapi.server.model.Cliente;
import com.training.microapi.server.repository.ClienteRepository;
import com.training.microapi.server.service.ClienteService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static com.training.microapi.test.helper.ClienteHelper.createBasicCliente;
import static com.training.microapi.test.helper.GenericHelper.createDefaultAnswer;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

@RunWith(SpringRunner.class)
public class ClienteServiceTest {

    @TestConfiguration
    static class ClienteServiceTestContextConfiguration {
        @Bean
        public ClienteService smsService() {
            return new ClienteService();
        }
    }

    @Autowired
    private ClienteService service;

    @MockBean
    private ClienteRepository repository;

    @MockBean
    private ClienteValidator validator;

    @Test
    public void save_cliente_with_success() {
        Cliente data = createBasicCliente("teste", "teste@teste.com");

        doNothing().when(validator).validate(any(Cliente.class));

        given(repository.save(any(Cliente.class))).willAnswer(createDefaultAnswer());

        Cliente ret = service.save(data);
        Assert.assertEquals(data.getNome(), ret.getNome());
        Assert.assertEquals(data.getEmail(), ret.getEmail());
    }




}

