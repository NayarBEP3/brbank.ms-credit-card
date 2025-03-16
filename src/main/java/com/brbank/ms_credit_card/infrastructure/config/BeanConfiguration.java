package com.brbank.ms_credit_card.infrastructure.config;

import com.brbank.ms_credit_card.domain.port.CreditCardUseCases;
import com.brbank.ms_credit_card.domain.service.CreditCardService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreditCardService creditCardService(final CreditCardUseCases creditCardUseCases) {
        return new CreditCardService(creditCardUseCases);
    }
}
