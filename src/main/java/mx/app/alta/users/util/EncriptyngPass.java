package mx.app.alta.users.util;

import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class EncriptyngPass {

    public String encode(String texto){
        return Base64.getEncoder().encodeToString(texto.getBytes(StandardCharsets.UTF_8));
    }

    public String decode(String textoBase){
         byte[] decodedBytes = Base64.getDecoder().decode(textoBase);
         return new String(decodedBytes, StandardCharsets.UTF_8);
    }

}
