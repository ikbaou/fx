package com.ibaou.trading.impl;

import java.time.Instant;

import com.ibaou.trading.common.domain.TradingContext;
import com.ibaou.trading.iface.Broker;
import com.ibaou.trading.iface.Strategy;

public class SimpleBacktester{
	
	TradingContext context = new TradingContext();
	Instant startDate;
	Instant endDate;
	Strategy strategy;	
	Broker broker;

	public SimpleBacktester(Broker broker, Strategy strategy) {
		super();
		this.strategy = strategy;
		this.broker=broker;
		this.broker.addTickListener(strategy);
	}

	public void start() {
		strategy.onStart(context);
		broker.run();
		strategy.onEnd();
	}

}
