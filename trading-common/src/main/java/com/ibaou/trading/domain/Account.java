package com.ibaou.trading.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Account {

	private BigDecimal balance;
	private BigInteger margin;
	private BigInteger lotSize;
	private String currency;
	
	private Account(Builder b) {
		this.balance=b.balance;
		this.margin=b.margin;
		this.lotSize=b.lotSize;
		this.currency=b.currency;
	}
	
	/*
	 * UTIL
	 */
	@Override
	public String toString() {
		return "Account [balance=" + balance + ", margin=" + margin + ", lotSize=" + lotSize + ", currency=" + currency
				+ "]";
	}	
		
	/*
	 * GETTERS / SETTERS
	 */

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigInteger getMargin() {
		return margin;
	}

	public void setMargin(BigInteger margin) {
		this.margin = margin;
	}

	public BigInteger getLotSize() {
		return lotSize;
	}

	public void setLotSize(BigInteger lotSize) {
		this.lotSize = lotSize;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	

	public static class Builder{
		
		private BigDecimal balance = BigDecimal.valueOf(0);
		private BigInteger margin = BigInteger.valueOf(1);
		private BigInteger lotSize = BigInteger.valueOf(100_000);
		private String currency = "USD";
		
		public Builder() {
			
		}
		
		public Builder setBalance(BigDecimal balance) {
			this.balance = balance;
			return this;
		}
		public Builder setMargin(BigInteger margin) {
			this.margin = margin;
			return this;
		}
		public Builder setLotSize(BigInteger lotSize) {
			this.lotSize = lotSize;
			return this;
		}
		public Builder setCurrency(String currency) {
			this.currency = currency;
			return this;
		}		
		
		public Account build() {
			return new Account(this);
		}
	}
	
}
