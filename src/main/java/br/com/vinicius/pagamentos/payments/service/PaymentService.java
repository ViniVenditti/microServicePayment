package br.com.vinicius.pagamentos.payments.service;

import br.com.vinicius.pagamentos.payments.entity.PaymentEntity;
import br.com.vinicius.pagamentos.payments.mapper.PaymentMapper;
import br.com.vinicius.pagamentos.payments.model.PaymentModel;
import br.com.vinicius.pagamentos.payments.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    @Autowired
    private PaymentMapper mapper;
    @Autowired
    private PaymentRepository repository;

    public PaymentModel savePayment(PaymentEntity entity) {
        PaymentEntity newPagamento = repository.save(entity);
        return mapper.to(newPagamento);
    }

    public List<PaymentModel> paymentExtract(Long idCartao) {
        List<PaymentEntity> listaEntity = repository.findAllByCardId(idCartao);
        return listaEntity
                .stream()
                .map(entity -> mapper.to(entity))
                .collect(Collectors.toList());
    }

}
