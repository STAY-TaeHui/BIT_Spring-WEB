package com.model;


//상품테이블과 1:1 매핑되는 DTO
public class OrderItem {
	private int itemid;
	private int num;
	private String remark;
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Override
	public String toString() {
		return "OrderItem [itemid=" + itemid + ", num=" + num + ", remark=" + remark + "]";
	}
	
}
