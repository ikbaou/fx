package com.ibaou.trading.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibaou.trading.common.domain.TradingContext;
import com.ibaou.trading.domain.OHLCTick;
import com.ibaou.trading.iface.Strategy;

public class DummyStrategy extends AbstractStrategy implements Strategy{
	
	private static Logger LOG = LoggerFactory.getLogger(DummyStrategy.class);

	@Override
	public void onStart(TradingContext context) {
		this.setContext(context);
		//System.out.println("DummyStrategy start");
	}

	@Override
	public void onTick(OHLCTick tick) {
		LOG.trace("tick: {}", tick);
	}

	@Override
	public void onEnd() {
		//System.out.println("DummyStrategy end");		
	}

}
