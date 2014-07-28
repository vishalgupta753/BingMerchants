package com.example.bingmerchantapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppUtils {

	public static String GetLocalSavedUserId() {
		String userId = null;
		InputStreamReader inputStreamReader = null;

		File file = MainActivity.context
				.getFileStreamPath(AppConstants.FileName);
		if (file.exists()) {
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
			} catch (Exception e) {

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
	
	public static Boolean checkIfMerchantExits(String mid)
	{
		// Use server apis here
		return false;
	}
	
	public static Boolean checkIfConsumerExits(String cid)
	{
		// Use server apis here
		return false;
	}
}
