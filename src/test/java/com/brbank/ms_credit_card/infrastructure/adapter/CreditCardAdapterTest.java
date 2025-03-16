package com.brbank.ms_credit_card.infrastructure.adapter;


import com.brbank.ms_credit_card.domain.model.CreditCardModel;
import com.brbank.ms_credit_card.infrastructure.persistance.entity.CreditCardEntity;
import com.brbank.ms_credit_card.infrastructure.persistance.repository.CreditCardJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CreditCardAdapterTest {

    @Mock
    private CreditCardJpaRepository creditCardJpaRepository;
    @InjectMocks
    private CreditCardAdapter creditCardAdapter;

    @BeforeAll
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createCreditCardOk() {
        final var creditCardModel = new CreditCardModel();
        creditCardModel.setCreditCardId(1L);
        creditCardModel.setCreditCardCvc("123");
        creditCardModel.setCreditCardNumber("123321");
        creditCardModel.setHolderName("Brayan Estrada");
        creditCardModel.setMonthValidThru("12");
        creditCardModel.setYearValidThru("27");
        final var creditCardEntity = new CreditCardEntity();
        creditCardEntity.setCreditCardId(1L);
        creditCardEntity.setCreditCardCvc("123");
        creditCardEntity.setCreditCardNumber("123321");
        creditCardEntity.setHolderName("Brayan Estrada");
        creditCardEntity.setMonthValidThru("12");
        creditCardEntity.setYearValidThru("27");
        Mockito.when(this.creditCardJpaRepository.save(ArgumentMatchers.any())).thenReturn(creditCardEntity);

        final var response = this.creditCardAdapter.createCreditCard(creditCardModel);

        Assertions.assertEquals(1L, response.getCreditCardId());
        Assertions.assertEquals("123", response.getCreditCardCvc());
        Assertions.assertEquals("123321", response.getCreditCardNumber());
        Assertions.assertEquals("Brayan Estrada", response.getHolderName());
        Assertions.assertEquals("12", response.getMonthValidThru());
        Assertions.assertEquals("27", response.getYearValidThru());
    }
}
