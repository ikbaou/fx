package com.ibaou.trading.iface;

import com.ibaou.trading.domain.OHLCTick;

public interface TickListener {
	
	void onTick(OHLCTick tick);

}
