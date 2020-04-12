package com.zjm.schoolmarket.service;

import com.zjm.schoolmarket.dto.WechatAuthExecution;
import com.zjm.schoolmarket.entity.WechatAuth;
import com.zjm.schoolmarket.exceptions.WechatAuthOperationException;

public interface WechatAuthService {

	/**
	 * 通过openId查找平台对应的微信帐号
	 *
	 * @param openId
	 * @return
	 */
	WechatAuth getWechatAuthByOpenId(String openId);

	/**
	 * 注册本平台的微信帐号
	 *
	 * @param wechatAuth
	 * @return
	 * @throws RuntimeException
	 */
	WechatAuthExecution register(WechatAuth wechatAuth) throws WechatAuthOperationException;

}
