package com.zrz.personalWeb.domain;

public class Business {
	private long id;
	private String type;
	private String info;
	
	public void setBid(long bid) {
		this.id = bid;
	}
	
	public long getBid() {
		return this.id;
	}
	
	public void setBtype(String type) {
		this.type = type;
	}
	
	public String getBtype() {
		return this.type;
	}
	
	public void setBinfo(String info) {
		this.info = info;
	}
	
	public String getBinfo() {
		return this.info;
	}
}
