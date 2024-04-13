package net.mikoto.laplace.statistics.service.impl;

import net.mikoto.laplace.statistics.model.sample.Sample;
import net.mikoto.laplace.statistics.service.SampleService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mikoto
 * &#064;date 2024/4/11
 * Create for laplace-statistics
 */
@Service
public class SampleServiceImpl implements SampleService {
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public SampleServiceImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void save(Sample sample) {
        rabbitTemplate.convertAndSend(sample);
    }
}
