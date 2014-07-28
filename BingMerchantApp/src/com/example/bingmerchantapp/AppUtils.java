package com.example.bingmerchantapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.example.bingmerchantapp.AppConstants.ConsumerStatus;
import com.example.bingmerchantapp.AppConstants.MerchantStatus;

import android.content.Context;

public class AppUtils {

	public static String GetLocalSavedUserId() {
		String userId = null;
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
				userId = sb.toString();
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
	
	public static void SaveLocalUserId(String userId)
	{
		System.out.println("Inside SaveUserId funtion");
		OutputStreamWriter outputStreamwriter = null;
		BufferedWriter bw = null;
		try {
			FileOutputStream fout = MainActivity.context.openFileOutput(AppConstants.FileName, Context.MODE_PRIVATE);
			outputStreamwriter = new OutputStreamWriter(fout);
			bw = new BufferedWriter(outputStreamwriter);
			bw.write(userId);
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
			MainActivity.CurrentUserId = userId;
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
			MainActivity.CurrentUserId = userId;
		}
	}
	
	public static Boolean checkIfMerchantExits(String mid)
	{
		// Use server apis here
		return true;
	}
	
	public static Boolean checkIfConsumerExits(String cid)
	{
		// Use server apis here
		return false;
	}
	
	public static Boolean StringIsNullOrEmpty(String str)
	{
		return str == null || str.equals("");
	}
}
