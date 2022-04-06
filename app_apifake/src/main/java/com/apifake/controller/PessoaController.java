package com.apifake.controller;

import com.apifake.dto.Pessoa;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PessoaController {

    @PostMapping(value = "/novapessoa")
    public String post(@RequestHeader("Authorization") String token,
                       @Valid Pessoa pessoa) {
        return "cadastrado com sucesso";

    }

}
