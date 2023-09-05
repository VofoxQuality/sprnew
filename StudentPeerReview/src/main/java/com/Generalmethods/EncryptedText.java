package com.Generalmethods;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptedText {

	String encodedString;

	// AES-Rijndael Algorithm
	public String EncryptCode(String id) {

		try {

			String input_text = id;
			String key = "Ij4nDa31T0k3nAvF"; // 128 bit key
			String iv = "7cLuc4o;Jnar0;s8";

			// Create key and cipher
			Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

			IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
			cipher.init(Cipher.ENCRYPT_MODE, aesKey, ivspec);

			// Encrypt the input text
			byte[] encrypted = cipher.doFinal(input_text.getBytes());
			String encryptText = Base64.getEncoder().encodeToString(encrypted);

			// Encode the Encrypted text
			String originalInput = encryptText;
			encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
			// Decrypt the encrypted code
			cipher.init(Cipher.DECRYPT_MODE, aesKey, ivspec);
			String decrypted = new String(cipher.doFinal(encrypted));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Return Encrypted and Encoded Text
		return encodedString;
	}
}
