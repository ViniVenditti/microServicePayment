package br.com.vinicius.pagamentos.payments.repository;

import br.com.vinicius.pagamentos.payments.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

    List<PaymentEntity> findAllByCardId(Long idCartao);

    void removeByCardId(Long idCartao);

}
