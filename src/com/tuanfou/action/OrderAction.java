package com.tuanfou.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tuanfou.dto.OrderInfo;
import com.tuanfou.service.OrderService;
import com.tuanfou.service.UserService;

public class OrderAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<OrderInfo> orderInfoList;
	private HttpServletRequest request;
	private Map<String,Object> session;
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
	/*
	 * 缓存用户的订单信息
	 */
	@SuppressWarnings("unchecked")
	public String addOrder(){
		request = ServletActionContext.getRequest();
		ActionContext context = ActionContext.getContext();
		session = context.getSession();
		//获取session里的用户id
		int userId = (Integer)session.get("userId");
		
		int groupFilmId = Integer.parseInt(request.getParameter("groupFlimId"));

		request.setAttribute("filmName", request.getParameter("filmName"));
		request.setAttribute("cinemaAddress", request.getParameter("cinemaAddress"));
		request.setAttribute("currentPrice", request.getParameter("currentPrice"));
		request.setAttribute("totalPrice", request.getParameter("totalPrice"));
		request.setAttribute("amount", request.getParameter("amount"));
		request.setAttribute("orderId", 1234567);
		//购票数量
		int amount = Integer.parseInt(request.getParameter("amount"));

		UserService userService = new UserService();
		OrderService orderService = new OrderService();
		int orderId = orderService.orderFilm(groupFilmId, userId, amount);
		if(orderId!=-1){
			request.setAttribute("balance",userService.getBalance(userId));
			request.setAttribute("orderId", orderId);
			return "OrderPay";
		}else{
			return ERROR;
		}
	}
	
	/*
	 * 支付订单
	 */
	public String payOrder(){
		request = ServletActionContext.getRequest();
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		OrderService orderService = new OrderService();
		if(orderService.pay(orderId)){
			return "pay_success";
		}else{
			return ERROR;
		}
	}
}
