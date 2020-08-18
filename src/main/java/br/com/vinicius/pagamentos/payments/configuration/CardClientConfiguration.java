package br.com.vinicius.pagamentos.payments.configuration;

import br.com.vinicius.pagamentos.payments.decoder.CardClientDecoder;
import br.com.vinicius.pagamentos.payments.model.CardClientFallback;
import feign.Feign;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;

public class CardClientConfiguration {

    @Bean
    public ErrorDecoder getCardClientDecoder(){
        return new CardClientDecoder();
    }

    @Bean
    public Feign.Builder builder(){
        FeignDecorators decoratos = FeignDecorators.builder()
            .withFallback(new CardClientFallback(), RetryableException.class)
            .build();

        return Resilience4jFeign.builder(decoratos);
    }

}
