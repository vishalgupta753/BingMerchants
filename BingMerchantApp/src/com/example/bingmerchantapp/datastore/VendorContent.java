package com.example.bingmerchantapp.datastore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class VendorContent {

	/**
	 * An array of sample (dummy) items.
	 */
	public static List<VendorItem> ITEMS = new ArrayList<VendorItem>();

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, VendorItem> ITEM_MAP = new HashMap<String, VendorItem>();

	static {
		// Add 3 sample items.
		addItem(new VendorItem("1", "Item 1","sd","sdss","csssc","csscw","sdsfwvcw"));
		addItem(new VendorItem("2", "Item 2","sd","sdss","csssc","csscw","sdsfwvcw"));
		addItem(new VendorItem("3", "Item 3","sd","sdss","csssc","csscw","sdsfwvcw"));
	}

	private static void addItem(VendorItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.MerchantId, item);
	}

	/**
	 * A dummy item representing a piece of content.
	 */
	public static class VendorItem {
		private String MerchantId;
		private String Name;
		private String Phone;
		private String Address;
		private String BusinessName;
		private ArrayList<String> Services;
		private String GeoLocation;
		
		public VendorItem(String merchantId, String name, String phone,
				String address, String businessName,String services, String geoLocation) {
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
}
