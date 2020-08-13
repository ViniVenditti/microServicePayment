package br.com.vinicius.pagamentos.payments.mapper;

import br.com.vinicius.pagamentos.payments.entity.PaymentEntity;
import br.com.vinicius.pagamentos.payments.model.PaymentModel;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    private PaymentMapper() {}

    public PaymentModel to (PaymentEntity entity){
        PaymentModel model = new PaymentModel();
        model.setDescription(entity.getDescription());
        model.setId(entity.getId());
        model.setCardId(entity.getCardId());
        model.setValue(entity.getValue());

        return model;
    }

    public PaymentEntity from (PaymentModel model) {
        PaymentEntity entity = new PaymentEntity();
        entity.setDescription(model.getDescription());
        entity.setValue(model.getValue());
        entity.setCardId(model.getCardId());

        return entity;
    }

}
