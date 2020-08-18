package br.com.vinicius.pagamentos.payments.model;

import br.com.vinicius.pagamentos.payments.exceptions.CardErrorException;

public class CardClientFallback implements CardClient {
    @Override
    public boolean verifyCard(Long cardId) {
        throw new CardErrorException();
    }
}
