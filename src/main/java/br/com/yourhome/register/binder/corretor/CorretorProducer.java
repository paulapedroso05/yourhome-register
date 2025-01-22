package br.com.yourhome.register.binder.corretor;

import br.com.yourhome.register.configuracao.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorretorProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void output(CorretorCadastradoMessage message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, "routing.key", message);
    }
}
