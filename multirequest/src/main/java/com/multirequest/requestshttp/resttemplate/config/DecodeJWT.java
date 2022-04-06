package com.multirequest.requestshttp.resttemplate.config;

import com.auth0.jwt.JWT;
import org.w3c.dom.events.EventException;

public class DecodeJWT {
    public String decodeUser(String token){
        String tokenUser = JWT.decode(token).getClaim("oracle.oauth.user_origin_id").asString();
        if(tokenUser.equals("SVC_ESCALE")){
            return "GEDOC_ESCALI";//--
        }
        if(tokenUser.equals("SVC_BEFORE")){
            return "GEDOC_LOJAS";
        }
        if(tokenUser.equals("SVC_VIVOMONEY") ||tokenUser.equals("svc_vivomoney")){
            return "GEDOC_VIVOMONEY";//--
        }
        if(tokenUser.equals("SVC_SHINOBI")){
            return "GEDOC_LLPP";
        }
        if(tokenUser.equals("SVC_M2")){
            return "GEDOC_M2";
        }
        if(tokenUser.equals("SVC_GEDOC")){
            return "SVC_GEDOC";
        }
        throw new EventException((short) 404,"Erro ao fazer o decode do Token. Algo parece errado no Token");
    }
}
