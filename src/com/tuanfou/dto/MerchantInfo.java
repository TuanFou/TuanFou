package com.tuanfou.dto;

import java.util.Set;

import com.tuanfou.pojo.Cinema;

/**
 * 商家信息
 * @author LN
 *
 */
public class MerchantInfo {
	private int merchantId;
	private String merchantName;
	private String password;
	private Set<Cinema> cinemas;
	public int getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setCinemas(Set<Cinema> cinemas) {
		this.cinemas = cinemas;
	}
	
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      	
}
