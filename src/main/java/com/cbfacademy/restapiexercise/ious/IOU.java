package com.cbfacademy.restapiexercise.ious;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class IOU {
    private final UUID id;
    String borrower;
    String lender;
    BigDecimal amount;
    Instant dateTime;

    public IOU(String borrower, String lender, BigDecimal amount, Instant dateTime) {
        this.id = UUID.randomUUID();
        this.borrower = borrower;
        this.lender = lender;
        this.amount = amount;
        this.dateTime = dateTime;
    }

    public IOU(UUID id) {
        this.id = id;
    }
}