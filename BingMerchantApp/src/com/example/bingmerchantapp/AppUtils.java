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

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.StrictMode;

import com.example.bingmerchantapp.data.Consumer;
import com.example.bingmerchantapp.data.Merchant;
import com.example.bingmerchantapp.data.Message;

public class AppUtils {

	public static void CheckLocalSavedUserId() {
		InputStreamReader inputStreamReader = null;

		File file = MainActivity.context
				.getFileStreamPath(AppConstants.FileName);
		if (file != null && file.exists()) {
			try {
				FileInputStream in = MainActivity.context
						.openFileInput(AppConstants.FileName);
				inputStreamReader = new InputStreamReader(in);
				BufferedReader bufferedReader = new BufferedReader(
						inputStreamReader);
				StringBuilder sb = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					sb.append(line);
				}
				String[] tokens = sb.toString().split(":");
				if (tokens.length == 2)
				{
					MainActivity.CurrentUserId = tokens[0];
					MainActivity.CurrentUserEnv = tokens[1].equals("c")?"Consumer":"Merchant";
				}
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
			String role = defaultRole.equals(AppConstants.DefaultAppEnv)?"c":"m";
			bw.write(userId+":"+role);
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
//		String userId = GetLocalSavedUserId();
//		if (AppUtils.StringIsNullOrEmpty(userId) || AppUtils.checkIfMerchantExits(userId)== false) {
//			
//			 MainActivity.CurrentUserMerchantStatus = MerchantStatus.NewMarchant;
//		}
//		else
//		{
//			MainActivity.CurrentUserMerchantStatus = MerchantStatus.ExistingMerchant;
//			MainActivity.CurrentMerchantUserId = userId;
//		}
	}
	
	public static void SetCuurentUserConsumerStatus()
	{
//		String userId = GetLocalSavedUserId();
//		if (AppUtils.StringIsNullOrEmpty(userId) || AppUtils.checkIfConsumerExits(userId)== false) {
//			
//			 MainActivity.CurrentUserConsumerStatus = ConsumerStatus.NewConsumer;
//		}
//		else
//		{
//			MainActivity.CurrentUserConsumerStatus = ConsumerStatus.ExistingConsumer;
//			MainActivity.CurrentConsumerUserId = userId;
//		}
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
	
	public static void SaveNewMerchant(Merchant merchant)
	{
		// Create a new HttpClient and Post Header
	    HttpClient httpclient = new DefaultHttpClient();
	    HttpPost httppost = new HttpPost(AppConstants.HttpUrl + "RegisterVendor.php");

	    try {
	        // Add your data
	        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
	        nameValuePairs.add(new BasicNameValuePair("VendorID", "M_"+merchant.getMerchantId()));
	        nameValuePairs.add(new BasicNameValuePair("BusinessName", merchant.getBusinessName()));
	        nameValuePairs.add(new BasicNameValuePair("VendorName", merchant.getName()));
	        nameValuePairs.add(new BasicNameValuePair("Address", merchant.getAddress()));
	        nameValuePairs.add(new BasicNameValuePair("PhoneNumber", merchant.getPhone()));
	        nameValuePairs.add(new BasicNameValuePair("Tags", merchant.getServices().toString()));
	        nameValuePairs.add(new BasicNameValuePair("GeoLocation", merchant.getGeoLocation()));
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
	
	public static void SaveNewConsumer(Consumer consumer)
	{
		// Create a new HttpClient and Post Header
	    HttpClient httpclient = new DefaultHttpClient();
	    HttpPost httppost = new HttpPost(AppConstants.HttpUrl+"RegisterUser.php");

	    try {
	        // Add your data
	        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
	        nameValuePairs.add(new BasicNameValuePair("UserID", "C_"+consumer.getConsumerId()));
	        nameValuePairs.add(new BasicNameValuePair("UserName", consumer.getName()));
	        nameValuePairs.add(new BasicNameValuePair("PhoneNumber", consumer.getPhone()));
	        nameValuePairs.add(new BasicNameValuePair("Address", consumer.getAddress()));
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
	    HttpPost httppost = new HttpPost(AppConstants.HttpUrl+"PlaceMessage.php");

	    try {
	        // Add your data
	        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
	        nameValuePairs.add(new BasicNameValuePair("VendorID", "M_" + merchant.getPhone()));
	        nameValuePairs.add(new BasicNameValuePair("UserID", "C_" + MainActivity.CurrentUserId));
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
	
	public static ArrayList<Merchant> GetAllMerchants()
	{
		ArrayList<Merchant> merchantList = new ArrayList<Merchant>();
		// Create a new HttpClient and Post Header
	    HttpClient httpclient = new DefaultHttpClient();
	    HttpPost httppost = new HttpPost(AppConstants.HttpUrl+"GetVendors.php");

	    try {
	    	System.out.println("in getAll merchants funtion");
	        // Add your data
	        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

	        // Execute HTTP Post Request
	        StrictMode.ThreadPolicy policy = new StrictMode.
	                ThreadPolicy.Builder().permitAll().build();
	        StrictMode.setThreadPolicy(policy); 
	        HttpResponse response = httpclient.execute(httppost);
	        String responseStr = "",inputLine ;
	        BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	              while ((inputLine = in.readLine()) != null) {
	                     responseStr=inputLine;
	              }
	              in.close();
	              
	        try {
				JSONArray responseJSONArray = new JSONArray(responseStr);
				for(int i=0;i<responseJSONArray.length();i++)
				{
					JSONObject merchantJson = responseJSONArray.getJSONObject(i);
					Merchant merchant = new Merchant(merchantJson.getString("VendorID"),
							merchantJson.getString("VendorName"),
							merchantJson.getString("PhoneNumber"),
							merchantJson.getString("Address"),
							merchantJson.getString("BusinessName"),
							merchantJson.getString("Tags"),
							merchantJson.getString("GeoLocation"),
							false);
					if(merchant.getServices().contains(MainActivity.Keyword) || MainActivity.Keyword.equals(""))
					merchantList.add(merchant);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	    } catch (ClientProtocolException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return merchantList;
	}
	
	public static ArrayList<Message> GetOpenQueriesForCurrentUser()
	{
		ArrayList<Message> messageData = new ArrayList<Message>();
		
		// Create a new HttpClient and Post Header
	    HttpClient httpclient = new DefaultHttpClient();
	    HttpPost httppost = new HttpPost(AppConstants.HttpUrl+"GetMessages.php");

	    try {
	        // Add your data
	        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	        nameValuePairs.add(new BasicNameValuePair("UserID", "C_"+MainActivity.CurrentUserId));
	        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

	        // Execute HTTP Post Request
	        StrictMode.ThreadPolicy policy = new StrictMode.
	                ThreadPolicy.Builder().permitAll().build();
	        StrictMode.setThreadPolicy(policy); 
	        HttpResponse response = httpclient.execute(httppost);
	        String responseStr = "",inputLine ;
	        BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	              while ((inputLine = in.readLine()) != null) {
	                     responseStr=inputLine;
	              }
	              in.close();
	              
	        try {
				JSONArray responseJSONArray = new JSONArray(responseStr);
				for(int i=0;i<responseJSONArray.length();i++)
				{
					JSONObject messageJson = responseJSONArray.getJSONObject(i);
					Message message = new Message();
					
					message.setConsumer(new Consumer(messageJson.getString("UserID"),
							messageJson.getString("Username"),
							messageJson.getString("userPhone"),
							messageJson.getString("userAddress")));
					message.setMerchant(new Merchant(messageJson.getString("VendorID"),
							messageJson.getString("VendorName"),
							messageJson.getString("VendorPhone"),
							messageJson.getString("vendorAddress"),
							messageJson.getString("BusinessName"),
							messageJson.getString("Tags"),
							"",
							false));
					message.setMessage(messageJson.getString("messageContent"));
					message.setMessageId(messageJson.getString("MessageID"));
					message.setMessageStatus(messageJson.getString("messageStatus"));
					
					messageData.add(message);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	    } catch (ClientProtocolException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
		return messageData;
	}
	
	public static ArrayList<Message> GetOpenQueriesForMerchant()
    {
          ArrayList<Message> messageData = new ArrayList<Message>();
          
          // Create a new HttpClient and Post Header
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(AppConstants.HttpUrl+"GetMessages.php");

        try {
            // Add your data
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("VenderID", "M_"+MainActivity.CurrentUserId));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            // Execute HTTP Post Request
            StrictMode.ThreadPolicy policy = new StrictMode.
                    ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy); 
            HttpResponse response = httpclient.execute(httppost);
            String responseStr = "",inputLine ;
            BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                  while ((inputLine = in.readLine()) != null) {
                         responseStr=inputLine;
                  }
                  in.close();
                  
            try {
                      JSONArray responseJSONArray = new JSONArray(responseStr);
                      for(int i=0;i<responseJSONArray.length();i++)
                      {
                            JSONObject messageJson = responseJSONArray.getJSONObject(i);
                            Message message = new Message();
                            
                            message.setConsumer(new Consumer(messageJson.getString("UserID"),
                                        messageJson.getString("Username"),
                                        messageJson.getString("userPhone"),
                                        messageJson.getString("userAddress")));
                            message.setMerchant(new Merchant(messageJson.getString("VendorID"),
                                        messageJson.getString("VendorName"),
                                        messageJson.getString("VendorPhone"),
                                        messageJson.getString("vendorAddress"),
                                        messageJson.getString("BusinessName"),
                                        messageJson.getString("Tags"),
                                        "",
                                        false));
                            message.setMessage(messageJson.getString("messageContent"));
                            message.setMessageId(messageJson.getString("MessageID"));
                            message.setMessageStatus(messageJson.getString("messageStatus"));
                            
                            messageData.add(message);
                      }
                } catch (JSONException e) {
                      // TODO Auto-generated catch block
                      e.printStackTrace();
                }
            
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
          
          return messageData;
    }

}
