package com.mlue.ecommerce.expection;

public class PurchaseProductException extends RuntimeException {
    public PurchaseProductException(String message) {
        super(message);
    }
}
