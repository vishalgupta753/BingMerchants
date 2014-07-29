package com.example.bingmerchantapp.data;

public class Consumer {
	
	private String Name;
	private String Phone;
	private String Address;
	public Consumer(String name, String phone, String address) {
		super();
		Name = name;
		Phone = phone;
		Address = address;
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
