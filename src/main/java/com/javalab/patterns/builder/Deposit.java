package com.javalab.patterns.builder;

import java.time.LocalDate;

public class Deposit {
    private double amount;
    private LocalDate date;
    private String payee;

    private Deposit(DepositBuilder builder) {
        this.amount = builder.amount;
        this.date = builder.date;
        this.payee = builder.payee;
    }

    public static class DepositBuilder {
        private double amount;
        private LocalDate date;
        private String payee;

        private DepositBuilder() {}
        public static DepositBuilder instance() {
            return new DepositBuilder();
        }

        public DepositBuilder amount(double amount) {
            this.amount = amount;
            return this;
        }

        public Deposit build() {
            return new Deposit(this);
        }
    }
}
