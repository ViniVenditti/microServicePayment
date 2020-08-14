package br.com.vinicius.pagamentos.payments.decoder;

import br.com.vinicius.pagamentos.payments.exceptions.CardNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CardClientDecoder implements ErrorDecoder {

    private ErrorDecoder errorDecoder = new Default();


    @Override
    public Exception decode(String s, Response response) {
        if(response.status() == 404) {
            return new CardNotFoundException();
        }
        return errorDecoder.decode(s, response);
    }
}
