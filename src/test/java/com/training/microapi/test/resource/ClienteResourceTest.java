package com.training.microapi.test.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.microapi.server.model.Cliente;
import com.training.microapi.server.resource.ClienteResource;
import com.training.microapi.server.service.ClienteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.training.microapi.test.helper.ClienteHelper.createBasicCliente;
import static com.training.microapi.test.helper.GenericHelper.createDefaultAnswer;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(secure = false, controllers = ClienteResource.class)
public class ClienteResourceTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private ClienteService service;


    @Test
    public void save_with_success() throws Exception {

        Cliente cliente = createBasicCliente("teste1", "teste@teste.com");

        given(service.save(any(Cliente.class))).willAnswer(createDefaultAnswer());

        String dados = mapper.writeValueAsString(cliente);

        mvc.perform(
                post("/api/cliente")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dados)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome", is(cliente.getNome())))
                .andExpect(jsonPath("$.email", is(cliente.getEmail())));

    }

}

