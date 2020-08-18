package br.com.vinicius.pagamentos.payments.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.GATEWAY_TIMEOUT, reason = "Aplicação fora!!")
public class CardErrorException extends RuntimeException {
}
