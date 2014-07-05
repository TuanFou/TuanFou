package com.tuanfou.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.tuanfou.dto.OrderInfo;
import com.tuanfou.service.OrderService;

public class OrderAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<OrderInfo> orderInfoList;
	public List<OrderInfo> getOrderInfoList() {
		return orderInfoList;
	}
	public void setOrderInfoList(List<OrderInfo> orderInfoList) {
		this.orderInfoList = orderInfoList;
	} 
	
	/*
	 * 获取指定用户所有订单
	 */
	public String getUserOrders(){
		//通过session获取用户id
		int id = 302010010;
		OrderService orderService = new OrderService();
		orderInfoList = orderService.getUserOrdersById(id);
		if(orderInfoList==null)
			return "error";
		return "myOrder";
		
	}
}
