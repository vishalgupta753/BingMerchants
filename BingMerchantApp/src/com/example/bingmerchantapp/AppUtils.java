package com.example.bingmerchantapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.example.bingmerchantapp.AppConstants.ConsumerStatus;
import com.example.bingmerchantapp.AppConstants.MerchantStatus;
import com.example.bingmerchantapp.data.Consumer;
import com.example.bingmerchantapp.data.Merchant;
import com.example.bingmerchantapp.data.Message;

import android.content.Context;
import android.os.StrictMode;

public class AppUtils {

	public static String GetLocalSavedUserId() {
		String userId = null;
		String defaultRole = "Consumer";
		InputStreamReader inputStreamReader = null;

		File file = MainActivity.context
				.getFileStreamPath(AppConstants.FileName);
		if (file != null && file.exists()) {
			try {
				System.out.println("Inside If of GetLocalSavedUserId");
				FileInputStream in = MainActivity.context
						.openFileInput(AppConstants.FileName);
				inputStreamReader = new InputStreamReader(in);
				BufferedReader bufferedReader = new BufferedReader(
						inputStreamReader);
				StringBuilder sb = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					System.out.println("Inside For loop: "+ line);
					sb.append(line);
				}
				String[] tokens = sb.toString().split(":");
				if (tokens.length == 2)
				{
					userId = tokens[0];
					defaultRole = tokens[1]=="c"?"Consumer":"Merchant";
				}
				System.out.println("GetLocalSavedUserId Completes: "+ userId);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(inputStreamReader != null)
				{
					try {
						inputStreamReader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

		return userId;
	}
	
	//defaultRole will be c or m. 
	//c => Consumer
	//m => Merchant
	public static void SaveLocalUserId(String userId, String defaultRole)
	{
		System.out.println("Inside SaveUserId funtion");
		OutputStreamWriter outputStreamwriter = null;
		BufferedWriter bw = null;
		try {
			FileOutputStream fout = MainActivity.context.openFileOutput(AppConstants.FileName, Context.MODE_PRIVATE);
			outputStreamwriter = new OutputStreamWriter(fout);
			bw = new BufferedWriter(outputStreamwriter);
			bw.write(userId+":"+defaultRole);
			System.out.println("SaveUserId funtion: Completed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				if(bw != null)
				{
					bw.close();
				}
				if(outputStreamwriter != null)
				{
					outputStreamwriter.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public static void SetCuurentUserMerchantStatus()
	{
		String userId = GetLocalSavedUserId();
		if (AppUtils.StringIsNullOrEmpty(userId) || AppUtils.checkIfMerchantExits(userId)== false) {
			
			 MainActivity.CurrentUserMerchantStatus = MerchantStatus.NewMarchant;
		}
		else
		{
			MainActivity.CurrentUserMerchantStatus = MerchantStatus.ExistingMerchant;
			MainActivity.CurrentMerchantUserId = userId;
		}
	}
	
	public static void SetCuurentUserConsumerStatus()
	{
		String userId = GetLocalSavedUserId();
		if (AppUtils.StringIsNullOrEmpty(userId) || AppUtils.checkIfConsumerExits(userId)== false) {
			
			 MainActivity.CurrentUserConsumerStatus = ConsumerStatus.NewConsumer;
		}
		else
		{
			MainActivity.CurrentUserConsumerStatus = ConsumerStatus.ExistingConsumer;
			MainActivity.CurrentConsumerUserId = userId;
		}
	}
	
	public static Boolean checkIfMerchantExits(String mid)
	{
		// Use server apis here
		return false;
	}
	
	public static Boolean checkIfConsumerExits(String cid)
	{
		// Use server apis here
		return true;
	}
	
	public static Boolean StringIsNullOrEmpty(String str)
	{
		return str == null || str.equals("");
	}
	
	public static void SaveNewMerchant(String name, String address, String location, String cellPhone, String services)
	{
		// Create a new HttpClient and Post Header
	    HttpClient httpclient = new DefaultHttpClient();
	    HttpPost httppost = new HttpPost("http://10.86.61.3:82/Sample/RegisterVendor.php");

	    try {
	        // Add your data
	        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
	        nameValuePairs.add(new BasicNameValuePair("VendorID", cellPhone));
	        nameValuePairs.add(new BasicNameValuePair("BusinessName", name));
	        nameValuePairs.add(new BasicNameValuePair("VendorName", name));
	        nameValuePairs.add(new BasicNameValuePair("Address", address));
	        nameValuePairs.add(new BasicNameValuePair("PhoneNumber", cellPhone));
	        nameValuePairs.add(new BasicNameValuePair("Tags", services));
	        nameValuePairs.add(new BasicNameValuePair("GeoLocation", location));
	        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

	        // Execute HTTP Post Request
	        StrictMode.ThreadPolicy policy = new StrictMode.
	                ThreadPolicy.Builder().permitAll().build();
	        StrictMode.setThreadPolicy(policy); 
	        httpclient.execute(httppost);
	        
	    } catch (ClientProtocolException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void SaveNewConsumer(String name, String address, String location, String cellPhone)
	{
		// Create a new HttpClient and Post Header
	    HttpClient httpclient = new DefaultHttpClient();
	    HttpPost httppost = new HttpPost("http://10.86.61.3:82/Sample/RegisterUser.php");

	    try {
	        // Add your data
	        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
	        nameValuePairs.add(new BasicNameValuePair("UserID", cellPhone));
	        nameValuePairs.add(new BasicNameValuePair("UserName", name));
	        nameValuePairs.add(new BasicNameValuePair("PhoneNumber", cellPhone));
	        nameValuePairs.add(new BasicNameValuePair("Address", address));
	        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

	        // Execute HTTP Post Request
	        StrictMode.ThreadPolicy policy = new StrictMode.
	                ThreadPolicy.Builder().permitAll().build();
	        StrictMode.setThreadPolicy(policy); 
	        httpclient.execute(httppost);
	        
	    } catch (ClientProtocolException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public static ArrayList<Merchant> GetQueryRelativeMerchants(String query)
	{
		ArrayList<Merchant> merchantData = new ArrayList<Merchant>();
		
		merchantData.add(new Merchant("a", "b", "12334", "abc", "dksk", "a,b,c", "", true));
		merchantData.add(new Merchant("b", "b", "12334", "abc", "dksk", "a,b,c", "",false));
		merchantData.add(new Merchant("c", "b", "12334", "abc", "dksk", "a,b,c", "", false));
		merchantData.add(new Merchant("d", "b", "12334", "abc", "dksk", "a,b,c", "", true));
		
		return merchantData;
	}
	
	public static void SendQueryToMerchant(Merchant merchant, String query)
	{
		// Create a new HttpClient and Post Header
	    HttpClient httpclient = new DefaultHttpClient();
	    HttpPost httppost = new HttpPost("http://10.86.61.3:82/Sample/PlaceMessage.php");

	    try {
	        // Add your data
	        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
	        nameValuePairs.add(new BasicNameValuePair("VendorID", merchant.getPhone()));
	        nameValuePairs.add(new BasicNameValuePair("UserID", MainActivity.CurrentConsumerUserId));
	        nameValuePairs.add(new BasicNameValuePair("Content", query));
	        nameValuePairs.add(new BasicNameValuePair("Status", "o"));
	        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

	        // Execute HTTP Post Request
	        StrictMode.ThreadPolicy policy = new StrictMode.
	                ThreadPolicy.Builder().permitAll().build();
	        StrictMode.setThreadPolicy(policy); 
	        httpclient.execute(httppost);
	        
	    } catch (ClientProtocolException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public static ArrayList<Message> GetOpenQueriesForMerchant()
	{
		ArrayList<Message> messageData = new ArrayList<Message>();
		
		Message m1 = new Message();
		Consumer c1 = new Consumer("JB Kiryana", "123456789", "Gachibowli"); 
		m1.setConsumer(c1);
		m1.setMessageId("34567");
		m1.setMessage("Need Following groceries intems by 5pm");
		
		Message m2 = new Message(); 
		m2.setConsumer(c1);
		m2.setMessageId("34568");
		m2.setMessage("Need Following groceries intems by 5pm");
		
		messageData.add(m1);
		messageData.add(m2);
		
		return messageData;
	}
}
