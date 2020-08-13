package br.com.vinicius.pagamentos.payments.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Cartão não habilitado para compra")
public class CardNotHabilitException extends RuntimeException {
}
