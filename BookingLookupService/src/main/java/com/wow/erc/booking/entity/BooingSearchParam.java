package com.wow.erc.booking.entity;

public class BooingSearchParam {
	public String poNo;
	public String dcNo;
	public String orderDate;
	public String deliveryDate;
	public String vendorNo;
	
	public String getPoNo() {
		return poNo;
	}
	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}
	public String getDcNo() {
		return dcNo;
	}
	public void setDcNo(String dcNo) {
		this.dcNo = dcNo;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getVendorNo() {
		return vendorNo;
	}
	public void setVendorNo(String vendorNo) {
		this.vendorNo = vendorNo;
	}
	
	@Override
	public String toString()
	{
		return ("poNo : " + this.poNo + 
				"dcNo : " + this.dcNo + 
				"orderDate : " + this.orderDate + 
				"deliveryDate : " + this.deliveryDate + 
				"vendorNo : " + this.vendorNo  
				);
	}
	
	
}
