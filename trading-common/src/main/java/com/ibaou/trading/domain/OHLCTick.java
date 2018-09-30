package com.ibaou.trading.domain;

import java.math.BigDecimal;
import java.time.Instant;

public class OHLCTick implements Comparable<OHLCTick>{

	String symbol;
	Instant time;
	BigDecimal open;
	BigDecimal high;
	BigDecimal low;
	BigDecimal close;
	BigDecimal volume;
			
	public OHLCTick(Instant time, String symbol,
			BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close,
			BigDecimal volume) {
		super();
		this.symbol = symbol;
		this.time = time;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
	}
	
	/*
	 * UTILS
	 */
	
	/* 
	 * compare by time and then by symbol name
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(OHLCTick o) {
		if(this.time.compareTo(o.getTime())==0) {
			return this.symbol.compareTo(o.getSymbol());
		}else {
			return this.time.compareTo(o.getTime());
		}
	}	
	
	@Override
	public String toString() {
		return "OHLCTick [symbol=" + symbol + ", time=" + time + ", open=" + open + ", high=" + high + ", low=" + low
				+ ", close=" + close + ", volume=" + volume + "]";
	}	
	
	/*
	 * GETTERS / SETTERS 
	 */
	
	public Instant getTime() {
		return time;
	}
	public void setTime(Instant time) {
		this.time = time;
	}
	public BigDecimal getOpen() {
		return open;
	}
	public void setOpen(BigDecimal open) {
		this.open = open;
	}
	public BigDecimal getHigh() {
		return high;
	}
	public void setHigh(BigDecimal high) {
		this.high = high;
	}
	public BigDecimal getLow() {
		return low;
	}
	public void setLow(BigDecimal low) {
		this.low = low;
	}
	public BigDecimal getClose() {
		return close;
	}
	public void setClose(BigDecimal close) {
		this.close = close;
	}
	public BigDecimal getVolume() {
		return volume;
	}
	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}		
}
