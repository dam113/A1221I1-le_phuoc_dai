package com.EXAM_MODULE2.model;

public class PaymentAccount extends Account{
    private String cardNumber;
    private double cash;

    public PaymentAccount(String cardCode, double cash) {
        this.cardNumber = cardCode;
        this.cash = cash;
    }

    public PaymentAccount(int id, String code, String name, String dateOpen, String cardCode, double cash) {
        super(id, code, name, dateOpen);
        this.cardNumber = cardCode;
        this.cash = cash;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    @Override
    public String toString() {
        return super.toString()+ cardNumber +","+cash;
    }
}
