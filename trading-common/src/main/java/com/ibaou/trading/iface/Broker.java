package com.ibaou.trading.iface;

public interface Broker {
	
	void run();
	void addTickListener(TickListener tickListener);
}
