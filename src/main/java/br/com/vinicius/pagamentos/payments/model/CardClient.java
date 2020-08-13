package br.com.vinicius.pagamentos.payments.model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "CARD")
public interface CardClient {

    @GetMapping(value = "/cartao/valid/{cardId}")
    boolean verifyCard(@PathVariable Long cardId);

}
