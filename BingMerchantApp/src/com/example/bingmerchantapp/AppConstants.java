package com.example.bingmerchantapp;

public class AppConstants {
	
	public static enum ConsumerStatus 
	{
		NewConsumer,
		ExistingConsumer
	}
	
	public static enum MerchantStatus 
	{
		NewMarchant,
		ExistingMerchant
	}
	
	final public static String FileName = "BingConnect.txt";
	
	final public static String DefaultAppEnv = "Consumer";
	
//	final public static String HttpUrl = "http://192.168.137.160:1234/";

	final public static String HttpUrl = "http://10.171.138.55:81/local/Php/";

}
