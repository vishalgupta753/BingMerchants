package com.example.bingmerchantapp.data;

public class Consumer {
	
	private String consumerId;
	private String Name;
	private String Phone;
	private String Address;
	public Consumer(String consumerId, String name, String phone, String address) {
		super();
		this.consumerId = consumerId;
		Name = name;
		Phone = phone;
		Address = address;
	}
	
	public String getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	

}
