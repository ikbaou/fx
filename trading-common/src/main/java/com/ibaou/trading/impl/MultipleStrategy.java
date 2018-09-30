package com.ibaou.trading.impl;

import java.util.ArrayList;
import java.util.List;

import com.ibaou.trading.common.domain.TradingContext;
import com.ibaou.trading.domain.OHLCTick;
import com.ibaou.trading.iface.Strategy;

public class MultipleStrategy extends AbstractStrategy implements Strategy{
	
	/**
	 * when set in the trading context, the multi strategy onTick will skip the other strategies
	 */
	public static String MULTI_STRATEGY_SKIP = "MULTI_STRATEGY_SKIP";
	
	List<Strategy> strategies = new ArrayList<>();

	@Override
	public void onStart(TradingContext context) {
		this.setContext(context);
		for(Strategy strategy:strategies) {
			strategy.setContext(context);
		}
		System.out.println("MultipleStrategy start");
	}

	@Override
	public void onTick(OHLCTick tick) {
		for(Strategy strategy:strategies) {
			strategy.onTick(tick);
			if(context.getParams().containsKey(MULTI_STRATEGY_SKIP)) {
				context.getParams().remove(MULTI_STRATEGY_SKIP);
				break;
			}
		}
		System.out.println("MultipleStrategy tick");
	}

	@Override
	public void onEnd() {
		System.out.println("DummyStrategy end");		
	}

}
