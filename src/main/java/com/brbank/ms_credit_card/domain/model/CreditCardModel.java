package com.brbank.ms_credit_card.domain.model;

public class CreditCardModel {

    private long creditCardId;
    private String creditCardNumber;
    private String monthValidThru;
    private String yearValidThru;
    private String creditCardCvc;
    private String holderName;

    public CreditCardModel() {
    }

    public long getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(long creditCardId) {
        this.creditCardId = creditCardId;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getMonthValidThru() {
        return monthValidThru;
    }

    public void setMonthValidThru(String monthValidThru) {
        this.monthValidThru = monthValidThru;
    }

    public String getYearValidThru() {
        return yearValidThru;
    }

    public void setYearValidThru(String yearValidThru) {
        this.yearValidThru = yearValidThru;
    }

    public String getCreditCardCvc() {
        return creditCardCvc;
    }

    public void setCreditCardCvc(String creditCardCvc) {
        this.creditCardCvc = creditCardCvc;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
}
