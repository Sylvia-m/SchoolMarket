package com.zjm.schoolmarket.exceptions;

public class ProductOperationException extends RuntimeException {


	private static final long serialVersionUID = 233223642423614019L;

	public ProductOperationException(String msg) {
		super(msg);
	}
}
