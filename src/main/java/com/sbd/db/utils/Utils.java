package com.sbd.db.utils;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import com.sbd.db.connection.ResourceBundleHandler;

/**
 <h1>Corporate Internet Banking Backend - service</h1>
 * @author Subodh Kumar
 * @version 1.0
 * @since   08-May-2017
 */

public class Utils
{
	private static String encryptionKey = null;
	private static SecretKeySpec key = null;
	
	/**
	 * Method to decrypt password
	 * @param encryptedPassword
	 * @return
	 * @throws EnowCorporateException
	 */
	public static String getDecryptedPassword(String encryptedPassword) throws Exception
	{
		try
		{
			encryptionKey = System.getenv("MY_INFO");
			key = new SecretKeySpec(encryptionKey.getBytes(), "Blowfish");

			return decode(encryptedPassword);
		}
		catch(InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | NumberFormatException ne)
		{
			ne.printStackTrace();
			throw new Exception("INVALIDENCRYPTION");
		}
	}
	
	/**
	 * Method to encrypt password
	 * @param plainPassword
	 * @return
	 * @throws Exception
	 */
	public static String getEncryptedPassword(String plainPassword) throws Exception
	{
		encryptionKey = System.getenv("MY_INFO");
		key = new SecretKeySpec(encryptionKey.getBytes(), "Blowfish");
		
		return encode(plainPassword);
	}
	
	
	/***
	 * Password decrypt method.	
	 * @param secret This is string to Decode
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws InvalidKeyException 
	 */
		private static String decode(String secret) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException 
		{	
			BigInteger objBigIntg = new BigInteger(secret, 16);
			byte encoding[] = objBigIntg.toByteArray();
			
			if (encoding.length % 8 != 0) 
			{
						int length = encoding.length;
						int newLength = (length / 8 + 1) * 8;
						int pad = newLength - length;
						byte old[] = encoding;
						encoding = new byte[newLength];
						for (int i = old.length - 1; i >= 0; i--)
								encoding[i + pad] = old[i];
			
						if (objBigIntg.signum() == -1) 
						{
								for (int i = 0; i < newLength - length; i++)
								{
									encoding[i] = -1;
								}							
						}
			}
			
			Cipher cipher = Cipher.getInstance("Blowfish");
			cipher.init(2, key);
			byte decode[] = cipher.doFinal(encoding);
			return new String(decode);
		}
		
		public static String encode(String secret) throws Exception {
			
			Cipher cipher = Cipher.getInstance("Blowfish");
			cipher.init(1, key);
			byte encoding[] = cipher.doFinal(secret.getBytes());
			BigInteger objBigIntg = new BigInteger(encoding);
			return objBigIntg.toString(16);
		
		}
		
	public static String formatMessage(String strMessage, Object...objArgs)
    {
		return MessageFormat.format(strMessage,objArgs);
	}

}	

