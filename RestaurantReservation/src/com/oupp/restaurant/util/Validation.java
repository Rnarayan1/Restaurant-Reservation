package com.oupp.restaurant.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	
	public static void main(String[] args) {

		boolean vName = nameValidation();
		System.out.println(vName);

		boolean vEmail = emailValidation();
		System.out.println(vEmail);

		boolean vPassword = passwordValidation();
		System.out.println(vPassword);

		boolean vPhoneNo = phoneNoValidation();
		System.out.println(vPhoneNo);

		boolean vDate = dateValidation();
		System.out.println(vDate);
	}

	public static boolean nameValidation() {
		String name = "Rakesh Kumar Sahoo";
		String regex = "^[a-zA-Z\\s]+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		return m.matches();

	}

	public static boolean emailValidation() {
		String emailId = "kumarbulu10361@2000";
		String regex = "^(.+)@(\\S+)$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(emailId);
		return m.matches();
	}

	public static boolean passwordValidation() {
		String passwd = "aaZZa44@";
		String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(passwd);
		return m.matches();

	}

	public static boolean phoneNoValidation() {
		String phno = "+92 453426bjy";
		String regex = "^\\s?((\\+[1-9]{1,4}[ \\-]*)|(\\([0-9]{2,3}\\)[ \\-]*)|([0-9]{2,4})[ \\-]*)*?[0-9]{3,4}?[ \\-]*[0-9]{3,4}?\\s?";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(phno);
		return m.matches();
	}

	public static boolean dateValidation() {
		String date = "01/05/2005";
		String regex = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(date);
		return m.matches();
	}
}
