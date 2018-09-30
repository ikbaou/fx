package com.ibaou.trading.impl;

import com.ibaou.trading.common.domain.TradingContext;
import com.ibaou.trading.domain.OHLCTick;
import com.ibaou.trading.iface.Strategy;

public class DummyStrategy extends AbstractStrategy implements Strategy{

	@Override
	public void onStart(TradingContext context) {
		this.setContext(context);
		//System.out.println("DummyStrategy start");
	}

	@Override
	public void onTick(OHLCTick tick) {
		//System.out.println("DummyStrategy tick: " + tick);
	}

	@Override
	public void onEnd() {
		//System.out.println("DummyStrategy end");		
	}

}
