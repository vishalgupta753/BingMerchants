package com.example.bingmerchantapp.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Merchant {
	
	private String MerchantId;
	private String Name;
	private String Phone;
	private String Address;
	private String BusinessName;
	private ArrayList<String> Services;
	private String GeoLocation;
	private Boolean IsFavouriteMerchant;
	
	/**
	 * An array of sample (dummy) items.
	 */
	public static List<Merchant> ITEMS = new ArrayList<Merchant>();

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, Merchant> ITEM_MAP = new HashMap<String, Merchant>();

	public static void addItem(Merchant item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.MerchantId, item);
	}
	
	public String toString()
	{
		return BusinessName;
	}
	
	public Boolean getIsFavouriteMerchant() {
		return IsFavouriteMerchant;
	}
	public void setIsFavouriteMerchant(Boolean isFavouriteMerchant) {
		IsFavouriteMerchant = isFavouriteMerchant;
	}
	
	public Merchant() {
		super();
	}
	public Merchant(String merchantId, String name, String phone,
			String address, String businessName,String services, String geoLocation, Boolean isFavouriteMerchant) {
		super();
		MerchantId = merchantId;
		Name = name;
		Phone = phone;
		Address = address;
		BusinessName = businessName;
		Services = new ArrayList<String>();
		for (String str : services.split(",")) {
			Services.add(str);
		}
		GeoLocation = geoLocation;
		IsFavouriteMerchant = isFavouriteMerchant;
	}
	public String getMerchantId() {
		return MerchantId;
	}
	public void setMerchantId(String merchantId) {
		MerchantId = merchantId;
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
	public String getBusinessName() {
		return BusinessName;
	}
	public void setBusinessName(String businessName) {
		BusinessName = businessName;
	}
	public ArrayList<String> getServices() {
		return Services;
	}
	public void setServices(ArrayList<String> services) {
		Services = services;
	}
	public String getGeoLocation() {
		return GeoLocation;
	}
	public void setGeoLocation(String geoLocation) {
		GeoLocation = geoLocation;
	}
}
