package com.example.bingmerchantapp.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Message {
	
	private Consumer consumer;
	private Merchant merchant;
	private String message;
	private String messageId;
	
	/**
	 * An array of sample (dummy) items.
	 */
	public static List<Message> ITEMS = new ArrayList<Message>();

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, Message> ITEM_MAP = new HashMap<String, Message>();

	public static void addItem(Message item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.messageId, item);
	}
	
	
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public Consumer getConsumer() {
		return consumer;
	}
	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}
	public Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
