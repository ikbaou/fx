package com.ibaou.trading.iface;

import com.ibaou.trading.common.domain.TradingContext;

public interface Strategy extends TickListener{
		
	void setContext(TradingContext context);
	
    void onStart(TradingContext context);

    void onEnd();
    
    
}
