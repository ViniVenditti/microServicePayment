package br.com.vinicius.pagamentos.payments.controller;

import br.com.vinicius.pagamentos.payments.entity.PaymentEntity;
import br.com.vinicius.pagamentos.payments.exceptions.CardNotHabilitException;
import br.com.vinicius.pagamentos.payments.mapper.PaymentMapper;
import br.com.vinicius.pagamentos.payments.model.CardClient;
import br.com.vinicius.pagamentos.payments.model.CardModel;
import br.com.vinicius.pagamentos.payments.model.PaymentModel;
import br.com.vinicius.pagamentos.payments.service.PaymentService;
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
        if (cardClient.verifyCard(payment.getCardId())){
            PaymentEntity entity = mapper.from(payment);
            PaymentModel model = service.savePayment(entity);
            return ResponseEntity.status(HttpStatus.CREATED).body(model);
        } else
            throw new CardNotHabilitException();

    }

    @GetMapping(value = "/{idCard}")
    public List<PaymentModel> getExtract(@PathVariable Long idCard) {
        return service.paymentExtract(idCard);
    }

}