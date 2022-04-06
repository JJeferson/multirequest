package com.multirequest.requestshttp.okhttp;

import com.multirequest.dto.Pessoa;
import lombok.SneakyThrows;
import okhttp3.*;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class OkHttp3RequestRest {

    @SneakyThrows
    public  String PostRequestOkHttp(Pessoa pessoa) {


        RequestBody corpo = new FormBody.Builder()
                .add("cpf", pessoa.getCpf())
                .add("nome", pessoa.getNome())
                .build();

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://127.0.0.1:8200/novapessoa")
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "qweqwe")
                .post(corpo)
                .build();

        Response response;
        String resposta="";
        try {
            response = client.newCall(request).execute();
            resposta = response.body().string();
            response.body().close();
        }catch (IOException e) {
            return "erro: " + e.getMessage();
        }

        return "Ok http funcionou!!!  Response: "+ resposta;

    }
}
