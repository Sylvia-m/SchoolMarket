package com.zjm.schoolmarket.exceptions;

public class ShopOperationException extends RuntimeException {
    private static final long serialVersionUID = 1531676742604966308L;

    public ShopOperationException(String msg){
        super(msg);
    }
}
