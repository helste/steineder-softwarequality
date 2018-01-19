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
		table.put("student", "cd73502828457d15655bbd7a63fb0bc8");
		table.put("homer", "dfa8327f5bfa4c672a04f9b38e348a70");
		table.put("marge", "f450b9ea18bf7d82dad122f729c0935f");
		table.put("bart", "f54146a3fc82ab17e5265695b23f646b");
		table.put("lisa", "ed14f4a4d7ecddb6dae8e54900300b1e");
		table.put("maggie", "1d3d37667a8d7eb02054c6afdf9e2e1c");
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
