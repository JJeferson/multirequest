package com.multirequest.requestshttp.resttemplate;

import com.multirequest.dto.Pessoa;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Component
public class RestTemplateRequest {

    @Autowired
    RestTemplate restTemplate;

    public String PostRequestRest(Pessoa pessoa) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "qweqwe");

        Pessoa corpoRequest  = new Pessoa();
        corpoRequest.setCpf(pessoa.getCpf());
        corpoRequest.setNome(pessoa.getNome());
        final HttpEntity<?> requestEntity = new HttpEntity<>(corpoRequest, headers);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://127.0.0.1:8200/novapessoa");

        String response = "";
        try {
            response = restTemplate.postForObject(builder.toUriString(),
                    requestEntity, String.class);
        }catch (Exception e){
            return "erro no request   "+e.getMessage();
        }
        return "Request ocorreu bem   "+response;
    }
}
