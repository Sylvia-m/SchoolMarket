package com.zjm.schoolmarket.exceptions;

public class WechatAuthOperationException extends RuntimeException {


	private static final long serialVersionUID = -8348727661612797650L;

	public WechatAuthOperationException(String msg) {
		super(msg);
	}
}
