package org.se.lab;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LoginServiceImpl implements LoginService {
	/*
	 * Simulate a database table
	 */
	private ConcurrentMap<String, String> table = new ConcurrentHashMap<String, String>();

	public LoginServiceImpl() {
		try {
			table.put("student", calculateMd5String("student"));
			table.put("homer", calculateMd5String("homer"));
			table.put("marge", calculateMd5String("marge"));
			table.put("bart", calculateMd5String("bart"));
			table.put("lisa", calculateMd5String("lisa"));
			table.put("maggie", calculateMd5String("maggie"));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean login(String username, String password, String usergroup) {
		if (table.containsKey(username)) {
			try {
				if (table.get(username).equals(calculateMd5String(password))) {
					return true;
				} else {
					return false;
				}
			} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
				return false;
			}
		} else {
			return false;
		}
	}

	private String calculateMd5String(final String message)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest algorithm = MessageDigest.getInstance("MD5");
		algorithm.update(message.getBytes("UTF-8"));
		byte[] bytes = algorithm.digest();
		return convertToHexString(bytes);
	}

	private String convertToHexString(byte[] bytes) {
		StringBuilder hex = new StringBuilder();
		for (byte b : bytes) {
			int i = (b & 0xff); // copy the byte bit pattern into int value
			hex.append(String.format("%02x", i));
		}
		return hex.toString();
	}
}
