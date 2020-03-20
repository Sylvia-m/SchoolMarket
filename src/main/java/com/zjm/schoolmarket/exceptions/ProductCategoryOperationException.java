package com.zjm.schoolmarket.exceptions;

public class ProductCategoryOperationException extends RuntimeException {


    private static final long serialVersionUID = 345532783974307780L;

    public ProductCategoryOperationException(String msg){
        super(msg);
    }
}
