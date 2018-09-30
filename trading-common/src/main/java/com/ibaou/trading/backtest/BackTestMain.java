package com.ibaou.trading.backtest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;
import java.util.PriorityQueue;
import java.util.Queue;

import com.ibaou.trading.domain.Account;
import com.ibaou.trading.domain.OHLCTick;
import com.ibaou.trading.iface.Broker;
import com.ibaou.trading.iface.Strategy;
import com.ibaou.trading.impl.DummyStrategy;
import com.ibaou.trading.impl.SimpleBacktester;
import com.ibaou.trading.impl.SimpleForexBroker;

public class BackTestMain {

	public static void main(String[] args) throws InterruptedException {
		// I need ticks
		System.out.println("filling up OHCLs");
		Long t0 = System.currentTimeMillis();
		Queue<OHLCTick> ticks = new PriorityQueue<>();
		for (int i = 0; i < 10_000; i++) {
			ticks.add(new OHLCTick(Instant.now(), "EURUSD", BigDecimal.valueOf(1.1), BigDecimal.valueOf(1.3),
					BigDecimal.valueOf(1.1), BigDecimal.valueOf(1.2), BigDecimal.valueOf(1500)));
			Thread.sleep(0,1);
		}
		System.out.println("filling end: " + (System.currentTimeMillis() - t0) + " ms");
		// an account or more
		Account acc = new Account.Builder().setCurrency("EUR").setBalance(BigDecimal.valueOf(10_000))
				.setMargin(BigInteger.valueOf(100)).setLotSize(BigInteger.valueOf(10_000)).build();

		// a strategy (or more)
		Strategy str = new DummyStrategy();

		// a broker
		Broker b = new SimpleForexBroker(acc, ticks);

		// a back-tester
		SimpleBacktester sbt = new SimpleBacktester(b, str);
		Long t = System.currentTimeMillis();
		System.out.println("start");
		sbt.start();
		System.out.println("end: " + (System.currentTimeMillis() - t) + " ms");
	}
}
