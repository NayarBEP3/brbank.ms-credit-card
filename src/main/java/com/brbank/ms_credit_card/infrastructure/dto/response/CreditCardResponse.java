package com.brbank.ms_credit_card.infrastructure.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreditCardResponse {
    private long creditCardId;
    private String creditCardNumber;
    private String monthValidThru;
    private String yearValidThru;
    private String creditCardCvc;
    private String holderName;
}
