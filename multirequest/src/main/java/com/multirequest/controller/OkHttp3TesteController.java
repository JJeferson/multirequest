package com.multirequest.controller;
import com.multirequest.dto.Pessoa;
import com.multirequest.requestshttp.okhttp.OkHttp3RequestRest;
import com.multirequest.requestshttp.resttemplate.RestTemplateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class OkHttp3TesteController {


    @Autowired
    OkHttp3RequestRest okHttp3RequestRest;

    @PostMapping(value = "/okhttp3_novapessoa")
    public String post(@RequestBody @Valid Pessoa pessoa) {

        return okHttp3RequestRest.PostRequestOkHttp(pessoa);

    }


}
