package com.ibaou.trading.impl;

import com.ibaou.trading.common.domain.TradingContext;
import com.ibaou.trading.iface.Strategy;

public abstract class AbstractStrategy implements Strategy{

	protected TradingContext context;
	
	@Override
	public void setContext(TradingContext context) {
		this.context = context;
	}

	public TradingContext getContext() {
		return context;
	}	

}
