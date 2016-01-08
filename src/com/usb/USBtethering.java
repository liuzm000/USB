package com.usb;

import java.lang.reflect.Method;

import android.content.Context;
import android.net.ConnectivityManager;

public class USBtethering {

	public static boolean isUSBConnected(Context ctx) {
		ConnectivityManager cm = (ConnectivityManager) ctx
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		String[] available = null;
		try {
			Method[] methodArray = cm.getClass().getMethods();
			for (Method method : methodArray) {

				if (method.getName().equals("getTetheredIfaces")) {
					available = null;
					available = (String[]) method.invoke(cm);
					if (available != null && available.length > 0) {
						for (int i = 0; i < available.length; i++) {
							return true;
						}
					}
				}
			}

		} catch (Exception e) {
			return false;
		}

		return false;
	}
}
