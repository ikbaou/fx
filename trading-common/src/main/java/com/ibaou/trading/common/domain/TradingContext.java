package com.ibaou.trading.common.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibaou.trading.iface.Order;
import com.ibaou.trading.iface.Trade;

public class TradingContext {
	
	private Map<String, String> params;
	private List<Trade> trades;
	private List<Order> orders;
	
	public TradingContext() {
		this.trades = new ArrayList<>(); 
		this.orders = new ArrayList<>(); 
		this.params = new HashMap<>();
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}

	public List<Trade> getTrades() {
		return trades;
	}

	public void setTrades(List<Trade> trades) {
		this.trades = trades;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
