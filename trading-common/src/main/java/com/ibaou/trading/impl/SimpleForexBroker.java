package com.ibaou.trading.impl;

import java.util.ArrayList;
import java.util.List;

import com.ibaou.trading.domain.Account;
import com.ibaou.trading.domain.OHLCTick;
import com.ibaou.trading.iface.Broker;
import com.ibaou.trading.iface.Order;
import com.ibaou.trading.iface.TickListener;

public class SimpleForexBroker implements Broker{
	
	List<TickListener> tickListeners;
	List<Order> orders;
	Iterable<OHLCTick> ticks;
	Account account;
	
	public SimpleForexBroker(Account account, Iterable<OHLCTick> ticks) {		
		this.account = account;
		this.ticks = ticks;
		this.tickListeners = new ArrayList<>();
	}
	
	public void run() {
		for(OHLCTick tick:ticks) {
			for(TickListener tickListener:tickListeners) {
				tickListener.onTick(tick);
			}
		}
	}

	@Override
	public void addTickListener(TickListener tickListener) {
		tickListeners.add(tickListener);		
	}

}
