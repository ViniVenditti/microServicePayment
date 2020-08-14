package br.com.vinicius.pagamentos.payments.configuration;

import br.com.vinicius.pagamentos.payments.decoder.CardClientDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class CardClientConfiguration {

    @Bean
    public ErrorDecoder getCardClientDecoder(){
        return new CardClientDecoder();
    }

}
