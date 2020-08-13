package br.com.vinicius.pagamentos.payments.controller;

import br.com.vinicius.pagamentos.payments.entity.PaymentEntity;
import br.com.vinicius.pagamentos.payments.exceptions.CardNotFoundException;
import br.com.vinicius.pagamentos.payments.exceptions.CardNotHabilitException;
import br.com.vinicius.pagamentos.payments.mapper.PaymentMapper;
import br.com.vinicius.pagamentos.payments.model.CardClient;
import br.com.vinicius.pagamentos.payments.model.InvoicePaidModel;
import br.com.vinicius.pagamentos.payments.model.PaymentModel;
import br.com.vinicius.pagamentos.payments.service.PaymentService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pagamento")
public class PaymentController {

    @Autowired
    private PaymentService service;
    @Autowired
    private PaymentMapper mapper;
    @Autowired
    private CardClient cardClient;

    @PostMapping
    public ResponseEntity<PaymentModel> doPayment(@RequestBody PaymentModel payment) {
        try{
            if (cardClient.verifyCard(payment.getCardId())){
                PaymentEntity entity = mapper.from(payment);
                PaymentModel model = service.savePayment(entity);
                return ResponseEntity.status(HttpStatus.CREATED).body(model);
            } else
                throw new CardNotHabilitException();
        } catch (FeignException.NotFound e) {
            throw new CardNotFoundException();
        }

    }

    @GetMapping(value = "/{idCard}")
    public List<PaymentModel> getExtract(@PathVariable Long idCard) {
        return service.paymentExtract(idCard);
    }

    @GetMapping(value = "/pagar/{cardId}")
    public InvoicePaidModel payInvoice(@PathVariable Long cardId){
        return service.invoicePaid(cardId);
    }
}
