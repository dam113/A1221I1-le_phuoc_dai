package com.EXAM_MODULE2.model;

public class SavingAccount extends Account{
    private double amount;
    private String dateSaving;
    private double rate;
    private int term;

    public SavingAccount(double amount, String dateSaving, double rate, int term) {
        this.amount = amount;
        this.dateSaving = dateSaving;
        this.rate = rate;
        this.term = term;
    }

    public SavingAccount(int id, String code, String name, String dateOpen, double amount, String dateSaving, double rate, int term) {
        super(id, code, name, dateOpen);
        this.amount = amount;
        this.dateSaving = dateSaving;
        this.rate = rate;
        this.term = term;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDateSaving() {
        return dateSaving;
    }

    public void setDateSaving(String dateSaving) {
        this.dateSaving = dateSaving;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return super.toString()+String.format("%s,%s,%s,%s", amount, dateSaving, rate, term);
    }
}
